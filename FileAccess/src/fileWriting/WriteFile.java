package fileWriting;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Writing writeFile = new Writing();
		writeFile.write();
	}
	
	

}

class Writing{
	public void write(){
		
		String phrase="test number 1";
		
		try {
			FileWriter fileWriter = new FileWriter("D:/Proyectos JAVA/CursoPildorasInformaticas/FileAccess/TestText/newText.txt");
			for(int i=0;i<phrase.length();i++) {
				fileWriter.write(phrase.charAt(i));
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
