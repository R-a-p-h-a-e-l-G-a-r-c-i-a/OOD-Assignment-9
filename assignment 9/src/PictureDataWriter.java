import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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


public class PictureDataWriter{
	public PictureDataWriter() {	
		}
		
	public static boolean writeToTextFile(ArrayList<PictureData> writing, String f) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (PictureData write: writing) {
				pw.println(write);			
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}