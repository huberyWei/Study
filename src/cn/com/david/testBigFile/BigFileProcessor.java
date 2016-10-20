package cn.com.david.testBigFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 核心类，大文件数据处理器
 * @author David
 */
public class BigFileProcessor {
	/**
	 * 记录的分隔符，每个分隔符占一行
	 */
	public static final String DEFAULT_SEPARTOR = "*****************";
	/**
	 * 致命毒药，用于干掉处理数据的线程。
	 */
	public final Object POSION = new Object();
	private BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(64);
	private String seperator = DEFAULT_SEPARTOR;
	private ErrorHandler errorHandler = ErrorHandler.PRINTER;
	/**
	 * 用于终止读取线程，非强制终止
	 */
	private volatile boolean running = false;
	/**
	 * 数据读取线程
	 */
	private Thread fileReader;
	/**
	 * 数据处理线程
	 */
	private Thread[] proccessors;
	
	public BigFileProcessor(final File file, final DataHandler handler) {
		fileReader = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Charset charset = Charset.defaultCharset();
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),charset));
					String line = null;
					ArrayList<String> cache = new ArrayList<String>();
					while(running && (line = reader.readLine()) != null){
						line = line.trim();
						if (seperator.equals(line)) {
							cache.add(reader.readLine());
							String[] data = cache.toArray(new String[cache.size()]);
							cache.clear();
							queue.put(data);
						}
					}
					reader.close();
				} catch (Throwable t) {
					errorHandler.doHandler(t);
				} finally{
					try {
						queue.put(POSION);
					} catch (InterruptedException e) {
						errorHandler.doHandler(e);
					}
					
				}
				
			}
		},"reader_thread");
		//默认创建的线程数，与CPU处理的内核数相同，楼主可以自行更改
		proccessors = new Thread[Runtime.getRuntime().availableProcessors()];

		Runnable worker = new Runnable() {
			@Override
			public void run() {
				try {
					for (;;) {
						Object obj = queue.take();
						if (obj == POSION) {
							queue.put(obj);
							break;
						}else {
							String[] data = (String[]) obj;
							handler.doHandler(data);
						}
					}
				} catch (Throwable t) {
					errorHandler.doHandler(t);
				}
				
			}
		};
		for (int i = 0; i < proccessors.length; i++) {
			proccessors[i] = new Thread(worker, "proccessor-thread_"+i);
		}
	}
	
	public void setErrorHandler(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}
	public void setSeperator(String seperator) {
		this.seperator = seperator;
	}
	
	/**
	 * 开启处理过程
	 */
	public synchronized void start(){
		System.out.println(fileReader);
		if (running) return;
		running = true;
		fileReader.start();
		for (int i = 0; i < proccessors.length; i++) {
			proccessors[i].start();
		}
	}
	/**
	 * 终端处理过程，非强制终端
	 */
	public synchronized void shutdown(){
		if (running) {
			running = false;
		}
	}
	
	/**
	 * 试图等待整个处理过程完毕
	 */
	public void join(){
		try {
			fileReader.join();
		} catch (InterruptedException e) {
			errorHandler.doHandler(e);
		}
		System.out.println("current name = "+Thread.currentThread().getName());
		for (int i = 0; i < proccessors.length; i++) {
			try {
				proccessors[i].join();
			} catch (InterruptedException e2) {
				errorHandler.doHandler(e2);
			}
		}
	}
	
}
