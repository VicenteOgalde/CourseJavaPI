package fileReading;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccessFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadFile readFile = new ReadFile();
		readFile.read();
	}

}

class ReadFile{
	
	public void read() {
		try {
			FileReader dataIn= new FileReader("D:/Proyectos JAVA/CursoPildorasInformaticas/FileAccess/TestText/newText.txt");
			BufferedReader meBuffer= new BufferedReader(dataIn);
			String line ="";
			/*int c=0;
			while(c!=-1) {
				c=dataIn.read();
				char letter=(char)c;
				System.out.print(letter);
			}*/
			while(line!=null) {
				line=meBuffer.readLine();
				if(line!=null) {
				System.out.println(line);
				}
			}
			dataIn.close();
		} catch (IOException e) {
			
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		
	}
}