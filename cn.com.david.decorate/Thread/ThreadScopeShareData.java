package Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {
	private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>(); // 共享数据集合
static int data =11;
	public static void main(String[] args) {
		/* 创建两个线程 */
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt(); // 造数据
					System.out.println(Thread.currentThread().getName()
							+ " put　data: " + data);
					threadData.put(Thread.currentThread(), data); // 将数据放入集合，以便线程操作数据
					new A().get();
					new B().get();
				}
			}).start();
			
		}

	}

	static class A {
		public void get() {
			int data = threadData.get(Thread.currentThread()); // 根据当前线程取得数据
			System.out.println("A from " + Thread.currentThread().getName()
					+ " get data:" + data);
		}
	}

	static class B {
		public void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println("B from " + Thread.currentThread().getName()
					+ " get data: " + data);
		}
	}
}