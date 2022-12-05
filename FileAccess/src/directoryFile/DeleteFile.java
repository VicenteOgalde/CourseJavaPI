package directoryFile;

import java.io.File;

public class DeleteFile {

	public static void main(String[] args) {
		
		String s = File.separator;
		String route = "D:/Proyectos JAVA/CursoPildorasInformaticas/FileAccess/"
				+"/TestFile/Test2/Text2.txt";
		  
		route.replace("/", s);
		File fDirectory = new File(route);
		fDirectory.delete();

	}

}
