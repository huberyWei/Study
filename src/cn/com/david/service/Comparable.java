package cn.com.david.service;



public interface Comparable {
	double num = 98; //被自动设置为public static final
	int compareTo(Object other);//接口中的所有方法自动属于public
	//boolean min(int x ,int y);
	//static boolean max(int x ,int y);//不能为static
	//Illegal modifier for the interface method max; only public & abstract are permitted
}
