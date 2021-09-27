package jet.app.util;

import java.io.*;
import java.nio.channels.FileChannel;

public class FileManager {
    public static void write(String path,String text){
    	if(!new File(path).exists())
			try {
				new File(path).createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	FileWriter fw;
		try {
			fw = new FileWriter(path);
			fw.write(text);
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    public static  String read(String path){
    	if(!new File(path).exists())
			try {
				new File(path).createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        String out = "";
		try {
			FileReader fr =
					new FileReader(path);

			int i;
			int ip = 0;
			char at[] = new char[1024*1024*7];
			while ((i=fr.read()) != -1)
			{at[ip]=(char)i;ip++;}
			out = String.valueOf(at).substring(0,ip);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
        return  out;
    }
    public static void copyFile(String to,String where){
		FileChannel src
				= null;
		try {
			src = new FileInputStream(
			to)
			.getChannel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileChannel dest
				= null;
		try {
			dest = new FileOutputStream(
			where)
			.getChannel();
			dest.transferFrom(src, 0, src.size());
			src.close();

			// Closing the destination channel
			dest.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Try block to check for exceptions

	}
}
