package cn.itcast.heima2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
	private Map<String, Object> cache = new HashMap<>();
	public static void main(String[] args) {
		
	}
	
//	public synchronized Object getData(String key){
	//多个读是可以实现并发的
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	public Object getData(String key){
		rwl.readLock().lock();
		Object value = null;
		try {
			value = cache.get(key);
			if (value == null) {
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try {
					if(value == null){
						value="aaaa";//实际是去queryDB();
					}
				} finally{
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			rwl.readLock().unlock();
		}
		return value;
	}
	
	
}
