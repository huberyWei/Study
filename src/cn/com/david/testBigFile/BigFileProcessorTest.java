package cn.com.david.testBigFile;

import java.io.File;

public class BigFileProcessorTest {

	public void testcase() {
		File file = new File("D:\\tmp\\11.txt");
		DataHandler dataHandler = new DataHandler() {
			
			@Override
			public void doHandler(String[] data) {
				synchronized (System.out) {
					for (String s : data) {
						System.out.print(s);
						System.out.print('\t');
					}
					System.out.println();
				}
				
			}
		};
		BigFileProcessor processor = new BigFileProcessor(file, dataHandler);
		processor.start();
		processor.join();
	}
	/**
	 * 程序入口
	 */
	public static void main(String[] args) {
		BigFileProcessorTest instance = new BigFileProcessorTest();
		instance.testcase();
	}

}
