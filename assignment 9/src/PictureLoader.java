import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * loads the png files into BufferedImage objects that you store in an ArrayList<BufferedImage>
 *
 * with a loadImagesFromPictureData function that returns an ArrayList<BufferedImage>. 
 * This function loads the images identified by the filename of each PictureData object into memory so that you can display them.
 * 
 * @author R1V1G
 *
 */
public class PictureLoader {
	public static ArrayList<BufferedImage> BU(){
		try {
			ArrayList<BufferedImage> buffedUp = new ArrayList<BufferedImage>();
			ArrayList<String> picNames = new ArrayList<String>();
			picNames.add("pic1.png");
			picNames.add("pic2.png");
			picNames.add("pic3.png");
			picNames.add("pic4.png");

			//variables
			String line;
			String[] parts;

			for (int i = 0; i < picNames.size(); i++) {
				BufferedImage img = ImageIO.read(new File(picNames.get(i)));
				buffedUp.add(img);			
			}
			return buffedUp;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
}