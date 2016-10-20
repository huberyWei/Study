package cn.com.david.Proxy;

/**
 * 代理接口处理给定名字的任务
 * @author David
 *
 */
public interface Subject {
	/**
	 * 执行给定名字的任务
	 * @param taskName
	 */
	public void dealTask(String taskName);
	
}
