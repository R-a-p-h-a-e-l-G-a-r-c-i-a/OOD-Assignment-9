import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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

//for making the pictures loop hint: a counter inside picture frame

public class PictureFrame extends JFrame {
	
	ArrayList <PictureData> PD = new ArrayList<PictureData>();
	ArrayList <BufferedImage> BI = new ArrayList<BufferedImage>();
	
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenuItem menitSave = new JMenuItem("Save");
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
				JOptionPane.showMessageDialog(null, "This has been created by"
						+ "Raphael de la Ghetto Garcia in November 2021"); //Fresh Prince of Bel-Air Reference
			}
		});
		menuHelp.add(menitAbout);
		mbar.add(menuHelp);
		setJMenuBar(mbar);
	}
	
	public void setitupLook() { //count variable goes here... somewhere. idk. i just wish I know what I'm doing
		setBounds(100,100,290,400);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		PicturePanel picPanel = new PicturePanel(this.BI.get(0));
		c.add(picPanel,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		
		//buttons
		JButton preButt = new JButton("Prev");
		panSouth.add(preButt);
		JButton saveButt = new JButton("Save");
		panSouth.add(saveButt);
		JButton nextButt = new JButton("Next");
		panSouth.add(nextButt);

		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu();
	}

	public PictureFrame(ArrayList<PictureData>PD ,ArrayList<BufferedImage>BI ) {
		this.PD = PD;
		this.BI = BI;
		setitupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
