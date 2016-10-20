package cn.itcast.heima2;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWruteLockTest {

	public static void main(String[] args) {
		final Queue3  q3 = new Queue3();
		for (int i = 0; i < 3; i++) {
			new Thread(){
				public void run() {
					while (true) {
						q3.get();
					}
				};
			}.start();
			
			new Thread(){
				public void run() {
					while (true) {
						q3.put(new Random().nextInt(10000));
					}
				};
			}.start();
		}
	}
}

class Queue3{
	private Object data = null;//共享数据，只能有一个线程能够
	private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();
	public void get(){
		rw1.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"be ready to read data");
			Thread.sleep((long)(Math.random()*1000));
			System.out.println(Thread.currentThread().getName()+"have read data:"+data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
		rw1.readLock().unlock();
		}
	}
	
	public void put(Object data){
		rw1.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"be ready to write data");
			Thread.sleep((long)(Math.random()*1000));
			this.data = data;
			System.out.println(Thread.currentThread().getName()+"have read data:"+data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			rw1.writeLock().unlock();
		}
	}
}
