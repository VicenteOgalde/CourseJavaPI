package directoryFile;

import java.io.File;

public class FileAccess {

	public static void main(String[] args) {
		
		File route = new File("/Proyectos JAVA/"
				+"CursoPildorasInformaticas/FileAccess/TestFile");
		System.out.println(route.getAbsolutePath());
		String [] fileNames=route.list();
		for(String i:fileNames) {
			System.out.println(i);
			File f= new File(route.getAbsolutePath(),i);
			if(f.isDirectory()) {
				String [] fileSub = f.list();
				for(String fs:fileSub) {
					System.out.println("files from "+f.getName()+": "+fs);
				}
			}
		}
	}

}
