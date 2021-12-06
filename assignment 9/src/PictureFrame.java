import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * class that defines the window the user will interact with. 
 * The PictureFrame will include a PicturePanel object that will SHOW THE IMAGE, 
 * as well as a panel that contains a JTextField for showing the date, a JTextArea for showing the description, 
 * and three buttons for moving to the previous image, moving to the next image, and saving the image data.
 * 
 * PictureFrame, a JFrame descendant. It should be 290 pixels wide and 400 pixels tall. 
 * It should use a BorderLayout to arrange the controls as shown in the examples above. 
 * The north part should be occupied by a PicturePanel. 
 * 
 * The center of the PictureFrame should consist of a JPanel that likewise uses a BorderLayout, 
 * with its north section filled with a JTextField for holding the date, 
 * its center section filled with the description JTextArea, 
 * and its south section filled with a JPanel that holds the three buttons.
 * @author R1V1G
 *
 */

public class PictureFrame extends JFrame {
	private JTextField artDate;
	private JTextArea artDesc;
	private int picNumb;

	
	private ArrayList<PictureData> PD = new ArrayList<PictureData>();
	private ArrayList<BufferedImage> BI = new ArrayList<BufferedImage>();
	
	//create object for picturePanel
	private PicturePanel BigPP; //REALLY MATURE RAPHAEL... I thought it was funny
	
	public void setupMenu() {
		//At the very top
		setTitle("Picture Frame");
		JMenuBar mbar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenuItem menitSave = new JMenuItem("Save"); //subitems for menu
		menitSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//save goes here...
			}
		});
		
		JMenuItem menitExit = new JMenuItem("Exit");
		menitExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuFile.add(menitSave);
		menuFile.add(menitExit);
		mbar.add(menuFile);
		
		JMenu menuHelp = new JMenu("Help");
		JMenuItem menitAbout = new JMenuItem("About");
		menitAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This has been created by "
						+ "Raphael de la Ghetto Garcia in November 2021"); //Fresh Prince of Bel-Air Reference
			}
		});
		menuHelp.add(menitAbout);
		mbar.add(menuHelp);
		setJMenuBar(mbar);
	}
	
	public void setupDisplay() {
		BigPP.setPicture(BI.get(picNumb)); //LOL
		artDate.setText(PD.get(picNumb).getFileDate());
		artDesc.setText(PD.get(picNumb).getFileDesc());
	}
	
	//setupGUI - forgot why I renamed it
	public void setitupLook() {
		setupMenu();
		setBounds(100,100,290,400); //don't add anymore of these
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		/*
		// Picture Panel - North Border
		BigPP = new PicturePanel();
		c.add(BigPP, BorderLayout.NORTH);
		
		// Picture Data Panel South Border
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new BorderLayout());
		artDesc = new JTextArea(5, 10);
		artDesc.setLineWrap(true);
		artDate = new JTextField(10);
		panSouth.add(artDate, BorderLayout.NORTH);
		panSouth.add(artDesc, BorderLayout.CENTER);
		
		// Button Panel - South Border
		JPanel panButt = new JPanel();
		panButt.setLayout(new FlowLayout());
		JButton preButt = new JButton("Prev");
		JButton saveButt = new JButton("Save");
		JButton nextButt = new JButton("Next");

		
		panButt.add(preButt);
		panButt.add(saveButt);
		panButt.add(nextButt);
		panSouth.add(panButt, BorderLayout.SOUTH);
		c.add(panSouth, BorderLayout.CENTER);*/

		
		//for the pictures
		BigPP = new PicturePanel();
		c.add(BigPP,BorderLayout.NORTH);
		
		//panSouth for the date and text		
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new BorderLayout());
		
		//initialize both date and description, add to panSouth 
		//borderLayout - new borderLayout create and add .North and .South
		artDate = new JTextField(20);
		//c.add(panSouth, BorderLayout.NORTH);
		artDesc = new JTextArea(1,1); //int row and int column
		artDesc.setLineWrap(true);
		panSouth.add(artDate,BorderLayout.NORTH);
		panSouth.add(artDesc,BorderLayout.CENTER);
		
		//buttons
		JPanel panButt = new JPanel();
		panButt.setLayout(new FlowLayout());		
		JButton preButt = new JButton("Prev");
		preButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerpict(-1);
				setupDisplay();
				repaint();
			}
		});	
		//note:
		//keep track of what index in the description (start at 0) 
		//click next increase image by 1. 
		//prev go back 1. don't go overboard.
		//there is no image 4. [0,1,2,3]
	
		JButton saveButt = new JButton("Save");
		saveButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveButt.addActionListener(this);
			}
		});
		JButton nextButt = new JButton("Next");
		nextButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerpict(1);
				setupDisplay();
				repaint();
			}
		});
		
		//add jpanels for buttons into pansouth and borderlayout is?
		
		panButt.add(preButt);
		panButt.add(saveButt);
		panButt.add(nextButt);
		panSouth.add(panButt,BorderLayout.SOUTH);
		c.add(panSouth, BorderLayout.CENTER);
	}
	
	public void changerpict(int numb) {//function changes pictures, and a counter
		picNumb = picNumb + numb;
		if (picNumb < 0) {
			picNumb = BI.size() - 1;
		} else {
			picNumb = picNumb % BI.size();
		}
	}

	public PictureFrame(ArrayList<PictureData> PD, ArrayList<BufferedImage> BI) {
		this.PD = PD;
		this.BI = BI;
		picNumb = 0;
		setitupLook(); //setupGUI
		setupDisplay();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}