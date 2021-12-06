import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * for writing the data back to a text file
 * 
 * When you click Save, the date and description of the currently shown 
 * picture should be changed to match what the user entered. 
 * 
 * Also, the descriptions.txt file should be overwritten with the new data 
 * using a PictureDataWriter class
 * @author R1V1G
 *
 */


public class PictureDataWriter {
	/*
	public static boolean writeToFile(ArrayList<PictureData> writing, File f) {
		 String fname = f.getName();
		 if (fname.endsWith(".txt")) {
			 return writeToTextFile(writing,f);
		 } else {
			 return false;
		 }
	}
	/*
	public static boolean writeToTextFile(ArrayList<PictureData> writing, File f) {
		try {
			PictureDataWriter pdw = new PictureDataWriter(new BufferedWriter(new FileWriter(f)));
			for (PictureData write: wrt) {
				pdw.println(write);
				
			}
			pdw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}*/
}
