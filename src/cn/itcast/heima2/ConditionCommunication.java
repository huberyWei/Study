package cn.itcast.heima2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunication {
 
	public static void main(String[] args) {
		
	}
	
	static class Business{
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		private boolean bShouldSub = true;
		public void sub(int i){
			lock.lock();
			try {
				while(!bShouldSub){
					try {
//						this.wait();
						condition.await();
						int x=3/1;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for (int j = 0; j <= 10; j++) {
					System.out.println("sub thread sequece of "+j+",loop of "+i);
				}
				
				bShouldSub = false;
//				this.notify();
				condition.signal();
			} finally{
				lock.unlock();
			}
		}
		
		public  void main(int i){
			lock.lock();
			try {
				while(bShouldSub){
					try {
//						this.wait();
						condition.await();
						int x=3/1;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for (int j = 0; j <= 100; j++) {
					System.out.println("main thread sequece of "+j+",loop of "+i);
				}
				
				bShouldSub = true;
//				this.notify();
				condition.signal();
			} finally{
				lock.unlock();
			}
		}
	}
}
