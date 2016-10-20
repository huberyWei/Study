package cn.com.david.Introspector;

import static org.junit.Assert.*;

import org.junit.Test;

public class BeanInfoUtilTest {

	@Test
	public void testSetProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testBeanInfoUtil(){
		UserInfo userInfo = new UserInfo();
		BeanInfoUtil.setProperty(userInfo, "userName","Lily");
	}
}
