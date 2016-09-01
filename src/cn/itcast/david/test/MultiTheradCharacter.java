package cn.itcast.david.test;


/**
 * @author David
 *
 */
public class MultiTheradCharacter implements Runnable{
	private Object obj;
	
	public MultiTheradCharacter(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		synchronized (obj) {
			for(char c= 'A' ; c<'Z';c++){
				System.out.print(c+"");
				obj.notifyAll();
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}

	}
	
}
