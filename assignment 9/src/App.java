import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) throws Exception {

		ArrayList<PictureData> PData = PictureDataReader.PD();
		ArrayList<BufferedImage> Pictures = PictureLoader.BU(PData);

		//testing 1 for pictureData - comment this stuff out later
		if (PData == null || PData.size() == 0) { 
			System.out.println("Something went wrong in Main or ArrayList contains nothing...");
		} else {
			System.out.println("We good fam.");
			//testing 2 for bufferedImage - comment this stuff out later
			if (Pictures == null || Pictures.size() == 0) { 
				System.out.println("Something went wrong in Main or ArrayList contains nothing...");
			} else {
				System.out.println("We good fam2.");
				PictureFrame PF = new PictureFrame(PData, Pictures);
				PF.setVisible(true);
			}
		}
	}
}