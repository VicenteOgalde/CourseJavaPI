package directoryFile;

import java.io.File;

public class RouteTest {

	public static void main(String[] args) {
		
		File file = new File("/Proyectos JAVA/"
				+ "CursoPildorasInformaticas/FileAccess/"
				+ "/TestFile/TestFileexample1");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.exists());

	}

}
