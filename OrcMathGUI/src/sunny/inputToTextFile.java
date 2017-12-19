package sunny;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class inputToTextFile {

	public inputToTextFile() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args)
	{
		System.out.println("Please input something. Please! I beg of you!");
		Scanner input = new Scanner(System.in);
		String in = input.nextLine();
		testSaveContent("test.txt", in);
	}

	private static void testSaveContent(String fileName, String str) {
		 try{    
			 FileWriter fw=new FileWriter(fileName);    
			 fw.write(str);    
			 fw.close();    
			 System.out.println("Success! File \""+fileName+"\" saved!");
		 }catch(IOException e){
			 System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		 }
	 }
}
