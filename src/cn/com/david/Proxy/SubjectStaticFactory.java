package cn.com.david.Proxy;

public class SubjectStaticFactory {
	//客户类调用此工厂方法获得代理对象
	//对客户类来说，其并不知道返回的是代理对象还是委托对象
	public static Subject getInstance(){
		return new ProxySubject(new RealSubject());
	}
}
