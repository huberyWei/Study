package cn.itcast.heima2;

public class MultiThreadShareData {
//	private static ShareData1 data1 = new ShareData1();
	public static void main(String[] args) {
		final ShareData1 data1 = new ShareData1();
		/*new Thread(data1).start();
		new Thread(data1).start();*/
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				data1.decrement();
				
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				data1.increment();
			}
		}).start();
	}
}   	

	class MyRunnable1 implements Runnable{
		private ShareData1 data1;
		public MyRunnable1(ShareData1 data1){
			this.data1 = data1;
		}
		@Override
		public void run() {
			data1.increment();
			
		}
		
	}
	class MyRunnable2 implements Runnable{
		private ShareData1 data1;
		public MyRunnable2(ShareData1 data1){
			this.data1 = data1;
		}
		@Override
		public void run() {
			data1.increment();
			
		}
		
	}

//同时操作一个J，可以同时被多个线程调用
class ShareData1/* implements Runnable*/{
	/*private int count =100;
	@Override
	public void run() {
		while (true) {
			count --;
			
		}
	}*/
	private int j =0;
	//synchronized：多个线程同时操作
	public synchronized void increment(){
		j++;
	}
	public synchronized void decrement(){
		j--;
	}
}