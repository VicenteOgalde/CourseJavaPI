package readAndWriteBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWrite {

	public static void main(String[] args) {
		int countByte=0;
		int[] dataInArr=new int[51506];
		try {
			FileInputStream readFile= new FileInputStream("D:/Proyectos JAVA/Curso"//read the jpg file
					+ "PildorasInformaticas/FileAccess/TestImage"
					+ "/Siesta_Beach.jpg");
			boolean endFile=false;
			while(!endFile) {
				int inByte=readFile.read();
				if(inByte!=-1) {
					dataInArr[countByte]=inByte;
				}else{
					endFile=true;
				}
				countByte++;
			}
			System.out.println(countByte);
			readFile.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		makeNewFile(dataInArr);

	}
	static void makeNewFile(int [] newData) {// copy of the jpg file
		try {
			FileOutputStream writeFile= new FileOutputStream("D:/Proyectos JAVA/Curso"
					+ "PildorasInformaticas/FileAccess/TestImage"
					+ "/Siesta_Beach_copy.jpg");
			for(int i : newData) {
				writeFile.write(i);
			}
			writeFile.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
