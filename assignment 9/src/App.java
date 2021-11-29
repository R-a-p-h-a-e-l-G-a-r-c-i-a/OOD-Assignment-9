import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		ArrayList<PictureData> PData = PictureDataReader.PD();
		ArrayList<BufferedImage> Pictures = PictureLoader.BU();

		//testing 1 for pictureData
		if (PData == null || PData.size() == 0) { 
			System.out.println("Something went wrong in Main or ArrayList contains nothing...");
		} else {
			System.out.println("We good fam.");
		}

		//testing 2 for bufferedImage
		if (Pictures == null || Pictures.size() == 0) { 
			System.out.println("Something went wrong in Main or ArrayList contains nothing...");
		} else {
			System.out.println("We good fam2.");
		}

	}
}