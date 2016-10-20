package cn.itcast.david.test;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * A ball that moves and bounces off the edges of a rectangle
 * @author David
 *
 */
public class Ball {
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	
	/**
	 * Moves the ball to the next position,reverseing direction if it hits one of the edges
	 */
	public void move(Rectangle2D bounds){
		x+=dx;
		y+=dy;
		if(x<bounds.getMinX()){
			x = bounds.getMinX();
			dx=-dx;
		}
		if(x + XSIZE >= bounds.getMaxX()){
			x=bounds.getMaxX();
		}
//		if(y<bounds.)
	}
}
