import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Needs a readPictureDataFromFile function that returns an ArrayList<PictureData>. 
 * You call it near the beginning of your program to create the PictureDataReader objects that will serve as the model for your application.
 * 
 * reading PictureData from a text file, and it must have a PictureDataWriter for writing the data back to a text file
 * @author R1V1G
 *
 */

public class PictureDataReader {
	public static ArrayList<PictureData> PD() {
		try {
			ArrayList<PictureData> picData = new ArrayList<PictureData>();
			Scanner fsc = new Scanner(new File("descriptions.txt"));

			//variables for Array
			String line;
			String[] parts;
			PictureData p; //from PictureData class
			
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim(); //takes in the first line
				if (line.length() > 0) {
					parts = line.split("\t");
					p = new PictureData(parts[0], parts[1], parts[2]); //calling constructor from PictureData class
					picData.add(p);
				}
			}
			return picData; 
		} catch (Exception ex) {
			ex.printStackTrace();
			//System.out.println(ex);
			return null;
		}
	}
}