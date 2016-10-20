package Frame;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SizeFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public SizeFrame(){
		//get screen dimension
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		//set frame width,height and let platform pick screen location
		setSize(screenWidth/2, screenHeight/2);
		
		//set frame icon
		Image img = new ImageIcon("dophon.png").getImage();
		setIconImage(img);
		
	}
}
