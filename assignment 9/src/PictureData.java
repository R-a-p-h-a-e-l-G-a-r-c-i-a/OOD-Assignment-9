
/**
 * PictureData with the necessary data attributes, getters, setters, constructors, and toString function.
 * Has fields for storing the filename, date, and description of each image
 * @author R1V1G
 *
 *hold our strings, hold constructors. multiple objects of pictureData.
 *public = call the value itself pd.name = no need for getters and setters if it is public
 *private = can't call the variable itself, why we need getters and setters to access
 */

public class PictureData {//DON'T TOUCH THIS ANYMORE PLEASE FOR THE LOVE OF GOD

	private String fileName, fileDate, fileDesc;

	public PictureData(String fileName, String fileDate, String fileDesc) {//constructor
		super();
		this.fileName = fileName;
		this.fileDate = fileDate;
		this.fileDesc = fileDesc;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDate() {
		return fileDate;
	}
	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}
	public String getFileDesc() {
		return fileDesc;
	}
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}	
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s" , fileName, fileDate, fileDesc);
	}
}