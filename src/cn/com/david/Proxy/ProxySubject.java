package cn.com.david.Proxy;

/**
 * 代理类，实现了代理接口
 * @author David
 *
 */
public class ProxySubject implements Subject {
	private Subject delegate;
	
	public ProxySubject(Subject delegate) {
		this.delegate = delegate;
	}

	/**
	 * 将请求分派给委托类执行，记录任务执行前后的时间
	 */
	@Override
	public void dealTask(String taskName) {
		long stime = System.currentTimeMillis();
		//将请求分派给委托类处理
		delegate.dealTask(taskName);
		long ftime = System.currentTimeMillis();
		System.out.println("执行任务耗时 "+(ftime-stime));

	}

}
