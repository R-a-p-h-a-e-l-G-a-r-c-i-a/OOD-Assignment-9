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
public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener {
	//setPicture and paintComponent functions

	/*
	private BufferedImage picture;
	
	public void setPicture(BufferedImage picture) {	
		try {
		picture = ImageIO.read(new File("pic1.png")); //should we try another name or name all of them on the same line?
	
		} catch (Exception ex) {
			System.out.println("The image can't be read.");
		}
		repaint(); //this should bring the image?
	}
	 */

	
	private String messageToShow;
	private int msgX, msgY;
	private int pointSize;
	private BufferedImage picture;
	
	public PicturePanel(BufferedImage picture) {
		addMouseListener(this);
		addMouseMotionListener(this);
		pointSize = 20;
		msgX = -1;
		msgY = -1;
		this.picture = picture;
	}
	
	
	public int getPointSize() {
		return pointSize;
	}
	public void setPointSize(int s) {
		if (s > 0) {
			pointSize = s;
		} else {
			pointSize = 5;
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		messageToShow = "Mouse entered the panel.";
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		messageToShow = "Mouse exited the panel.";
		repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		messageToShow = String.format("Mouse clicked at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		messageToShow = String.format("Mouse pressed at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		messageToShow = String.format("Mouse released at (%d, %d)", e.getX(),e.getY());
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		messageToShow = String.format("Mouse is at (%d, %d)", e.getX(),e.getY());
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		messageToShow = String.format("Mouse dragged at (%d, %d)", e.getX(),e.getY());
		msgX = e.getX();
		msgY = e.getY();
		repaint();		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.picture,0,0,null);
		g.drawString(messageToShow, 20,20);

		/*
		try {
			BufferedImage img = ImageIO.read(new File("pic1.png"));
			g.drawImage(img, 150, 60, null);
		} catch (Exception ex) {
			System.out.println("The image can't be read... "
					+ "unless it's supposed to be invisible"
					+ "I don't get art.");
		}*/
	}
}