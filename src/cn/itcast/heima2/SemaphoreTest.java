package cn.itcast.heima2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore sp = new Semaphore(3);
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						sp.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("线程"+Thread.currentThread().getName()
							+"进入，当前已有"+(3-sp.availablePermits())+"可用");
//					Thread.sleep((Long)(Math.random()*10000));
					sp.release();System.out.println("线程"+Thread.currentThread().getName()
							+"即将离开");
					sp.release();
					sp.release();System.out.println("线程"+Thread.currentThread().getName()
							+"离开");
				}
			};
			service.execute(runnable);
		}
	}

}
