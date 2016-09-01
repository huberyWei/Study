package cn.itcast.david.test;
/**
 * @ClassName	Test_7
 * @Description 多次调用一函数，发现异常继续遍历，否则退出循环
 * @author David (作者信息)
 * @version V1.0.0
 * @date 20180831
 *
 */
public class Test_7{
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			try {
				String str = test(i);
				if(str!=null){
					break;
				}
				
			} catch (Exception e) {
				System.out.println("mian exception");
			}
		}
	}
	
	public static String test(int k){
		try {
			if(k!=3){
				int i = 10/0;
			}
			System.out.println("no exception");
			return "hello";
		} catch (Exception e) {
			System.out.println("exception");
			return null;
		}
	}
}
