package cn.com.david.Proxy;
/**
 * 真正执行任务的类，实现了代理接口
 * @author David
 *
 */
public class RealSubject implements Subject {
	@Override
	public void dealTask(String taskName) {
		System.out.println("正在执行的任务： " + taskName);
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
