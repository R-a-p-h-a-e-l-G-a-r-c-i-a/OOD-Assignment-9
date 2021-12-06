import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * loads the png files into BufferedImage objects that you store in an ArrayList<BufferedImage>
 *
 * with a loadImagesFromPictureData function that returns an ArrayList<BufferedImage>. 
 * This function loads the images identified by the filename of each PictureData object 
 * into memory so that you can display them.
 * 
 * @author R1V1G
 *
 */
public class PictureLoader {
	//loadImagesFromPictureData function rename?
	public static ArrayList<BufferedImage> BU (ArrayList <PictureData> pData){ 
		try {
			ArrayList<BufferedImage> buffedUp = new ArrayList<BufferedImage>();

			//variables
			String line;
			String[] parts;

			for (PictureData pd: pData) {
				BufferedImage img = ImageIO.read(new File(pd.getFileName()));
				buffedUp.add(img);
			}
			return buffedUp;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
}