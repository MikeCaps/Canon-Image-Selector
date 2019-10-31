import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class ImageSelector2 {
	
	/****************************************************************************************************************
	* ImageSelector2 Uses Canon Rebel SD Card file formatting (IMG_XXXX) to easily move photos from your SD Card to *
	* any (new or existing) file directory in standard Windows picture folder. ImageSelector2 uses an ArrayList to  *
	* store photo numbers; all you need to know is the directory name on your SD card, as well as the image numbers *
	* stored there. ImageSelector2 automatically creates a Windows batch file (output.bat) that copys all photos    *
	* entered by user. ImageSelector2 can easily be used with RunImageSelector.bat in order to create and run       *
	* output.bat automatically.                                                                                     *
	****************************************************************************************************************/

	public static void main(String[] args) throws IOException {
		ArrayList<String> pics = new ArrayList<String>();
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a photo directory:");
		String directory = kb.nextLine();
		System.out.println("Enter a file extension (RAW = CR2, JPEG = JPG):");
		String fileExt = kb.nextLine();
		System.out.println("What is your destination folder?");
		String filePathOut = kb.nextLine();
		String nextPic = "";
		while(!nextPic.equalsIgnoreCase("q")) {
			System.out.println("Please enter an image number (enter q when finished).");
			nextPic = kb.nextLine();
			pics.add(nextPic);
		}
		
		PrintStream out = new PrintStream(new FileOutputStream("output.bat"));
		System.setOut(out);
		System.out.println("mkdir C:\\Users\\mcaps\\pictures\\" + filePathOut);
		System.out.println("cd " + directory);
		for(int i = 0; i < pics.size(); i++) { 
			System.out.println("copy IMG_" + pics.get(i) + "." + fileExt + " " + " C:\\Users\\mcaps\\pictures\\" + filePathOut);
		}
		kb.close();
	}//end of main
	
}//end of ImageSelector2
