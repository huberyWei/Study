package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class NotHelloWorld {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new NotHelloWorldFrame();
				frame.setTitle("Not Hello world");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
	}
}
