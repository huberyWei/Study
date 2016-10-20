package Thread;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingletonTestTest {

	@Test
	public void test() {
		SingletonTest singletonTest = SingletonTest.getInstance();
		singletonTest.setName("liyongcheng");
		System.out.println(singletonTest);
	}

}
