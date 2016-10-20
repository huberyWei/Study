package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SimpleFrameTest {
	public static void main(String[] args) {
		//事件分派线程，线程将鼠标点击和按键控制转移到用户接口主键
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				//关闭这个框架，让程序简单的退出
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//显示框架
				frame.setVisible(true);
				//退出main并没有终止程序，终止的只有主线程。事件分派线程始终保持程序处于激活状态。
				//知道关闭框架或者调用System.exit方法终止线程。
			}
		});
		
	}
}
