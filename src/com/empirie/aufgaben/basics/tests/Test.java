package com.empirie.aufgaben.basics.tests;

import java.io.*;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		

			File file = new File("C:\\Users\\hotzelm\\Desktop\\test.txt");
			String text = "AHallo1";
			byte[] bText = text.getBytes();
			
//			OutputStream os = new FileOutputStream("a");
//			
//			InputStream is = new FileInputStream("C:\\Users\\hotzelm\\Desktop\\test.txt");
//			
//			try {
//				int c = is.read();
//				System.out.println(c);
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
			
//			try {
//				OutputStream os = new FileOutputStream(file);
//				os.write(bText);
//				
//			} catch(IOException e) {
//				e.printStackTrace();
//			}
//			
			try {
				FileOutputStream fos = new FileOutputStream(file);
				OutputStream bos = new BufferedOutputStream(fos);
				bos.write(bText);
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				InputStream bis = new BufferedInputStream(new FileInputStream(file));
				char c = (char)bis.read();
				System.out.println(c);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		
	}

}
