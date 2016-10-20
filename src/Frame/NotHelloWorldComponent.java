package Frame;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
/**
 * a component that displays a message
 * @author David
 *
 */
public class NotHelloWorldComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y =100;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
	
	
}
