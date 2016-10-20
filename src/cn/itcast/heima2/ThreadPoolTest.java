package cn.itcast.heima2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void main(String[] args) {
//		ExecutorService threadPool = Executors.newFixedThreadPool(3);
//		ExecutorService threadPool =Executors.newCachedThreadPool();
		ExecutorService threadPool =Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						System.out.println(Thread.currentThread().getName()+" loop of "+j+" for task "+task);
					}
				}
			});
		}
//		System.out.println("all of 10 task have commited!");
		threadPool.shutdown();
//		threadPool.shutdownNow();
		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(//schedule(
				new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bomming!");
				
			}
		}, 6, 2,TimeUnit.SECONDS);
	}
}
