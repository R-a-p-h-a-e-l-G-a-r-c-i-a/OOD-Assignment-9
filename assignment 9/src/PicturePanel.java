import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 *  has a BufferedImage object called 'picture (in italics)' as a private 
 *  data member as well as a setPicture function 
 *  that takes in a BufferedImage object to set picture to. 
 *  
 *  When setPicture changes the value of the picture private data member, 
 *  it calls repaint, so that PicturePanel's paintComponent function renders 
 *  the new image.
 *  
 * @author R1V1G
 *
 */
public class PicturePanel extends JPanel implements MouseMotionListener {

	private String messageToShow; //mouseStatus
	private int msgX, msgY;
	private BufferedImage picture;
	
	public PicturePanel() {
		setPreferredSize(new Dimension(290,190));
		messageToShow = "(x=0, y=0)"; //starting message
		addMouseMotionListener(this);
		msgX = 10; //starting location
		msgY = 20; //starting location
	}
	
	//setPictureFunction - takes in buffered object (1 per time), 
	//that objectname, replaces buffered image object initialize in there, repaint()	
	public void setPicture(BufferedImage picture) {
		this.picture = picture;
		repaint();
	}
	
	//the mouse events
	@Override
	public void mouseMoved(MouseEvent e) {
		messageToShow = String.format("(x=%d, y=%d)", e.getX(),e.getY());
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		messageToShow = String.format("(x=%d, y=%d)", e.getX(),e.getY());
		msgX = e.getX();
		msgY = e.getY();
		repaint();		
	}
	
	//graphics
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.picture,0,0,null);
		//g.drawString(messageToShow, msgX, msgY); //this will move where ever user clicks
	}
}