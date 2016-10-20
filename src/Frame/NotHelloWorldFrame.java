package Frame;

import javax.swing.JFrame;

public class NotHelloWorldFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public NotHelloWorldFrame(){
		add(new NotHelloWorldComponent());
		pack();
	}
}
