package cn.com.david.Introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanInfoUtil {
	public static void setProperty(UserInfo userInfo, String propertyName,String propertyValue){
		PropertyDescriptor propertyDescriptor = null;
		try {
			propertyDescriptor = new PropertyDescriptor(propertyName, UserInfo.class);
			Method methodSetUserName = propertyDescriptor.getWriteMethod();
			methodSetUserName.invoke(userInfo, propertyValue);
			System.out.println(propertyDescriptor.getPropertyType().getName());
			
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static void setPropertyByIntrospector(UserInfo userInfo,String userName){
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(userInfo.getClass());
			PropertyDescriptor[] propertyDescs = beanInfo.getPropertyDescriptors();
			if (propertyDescs != null && propertyDescs.length>0) {
				for (PropertyDescriptor propertyDescriptor : propertyDescs) {
					
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}
}
