package fileReading;


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
			FileReader dataIn= new FileReader("D:/Proyectos JAVA/CursoPildorasInformaticas/Readme.txt");
			int c=0;
			while(c!=-1) {
				c=dataIn.read();
				char letter=(char)c;
				System.out.print(letter);
			}
			dataIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		
	}
}