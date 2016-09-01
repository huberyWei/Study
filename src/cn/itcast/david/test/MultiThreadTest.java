package cn.itcast.david.test;

public class MultiThreadTest {
	public static void main(String[] args) {
		//共享资源
		Object obj = new Object();
		MultiThreadNumber number = new MultiThreadNumber(obj);
		MultiTheradCharacter character = new MultiTheradCharacter(obj);
		Thread threadNumberThread = new Thread(number);
		Thread threadCharacterThread = new Thread(character);
		threadNumberThread.start();
		threadCharacterThread.start();
		
	}

}
