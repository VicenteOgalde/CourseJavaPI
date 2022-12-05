package directoryFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) {
		
		String s = File.separator;
		String route = "D:/Proyectos JAVA/CursoPildorasInformaticas/FileAccess/"
				+"/TestFile/Test2/Text2.txt";
		  
		route.replace("/", s);
		File fDirectory = new File(route);
		try {
			System.out.println(fDirectory.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Writing wr = new Writing();
		wr.write(fDirectory.getAbsolutePath());
		

	}

}
class Writing{
	public void write(String routeFile) {
		String phrase="example 2";
		try {
			FileWriter write = new FileWriter(routeFile);
			for(int i=0;i<phrase.length();i++) {
				write.write(phrase.charAt(i));
			}
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
