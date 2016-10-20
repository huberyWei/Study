package Thread;

public class SingletonTest {
	private SingletonTest(){};
	/*
	public static SingletonTest getInstance(){
		return instance;
	}
	private static SingletonTest instance = new SingletonTest();
	*/
	
	public static synchronized SingletonTest getInstance(){
		if (instance==null) {
			instance = new SingletonTest();
		}
		return instance;
	}
	private static SingletonTest instance = null;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setInstance(SingletonTest instance) {
		this.instance = instance;
	}
	@Override
	public String toString() {
		return "SingletonTest [name=" + name + "]";
	}
	
}
