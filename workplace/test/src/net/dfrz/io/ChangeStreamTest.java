package net.dfrz.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ChangeStreamTest {

	// public static void main(String[] args) {
	// try {
	// OutputStreamWriter ow = new OutputStreamWriter(new
	// FileOutputStream("f:/xiaoyu.txt"));
	// ow.write("xiaoyu is a good man");
	//System.out.println(ow.getEncoding());
	// ow.flush();
	// ow.close();
	//			
	// ow = new OutputStreamWriter(new
	// FileOutputStream("f:/xiaoyu.txt",true),"iso8859-1");
	// ow.write("and he is a student");
	// System.out.println(ow.getEncoding());
	// ow.flush();
	// ow.close();
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public static void main(String[] args) {

		InputStreamReader isr = new InputStreamReader(System.in);

		BufferedReader bs = new BufferedReader(isr);

		String string = null;
		try {
			string = bs.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (string != null) {
				if (string.equalsIgnoreCase("exit"))
					break;
				System.out.println(string.toLowerCase());
				string = bs.readLine();
			}
			bs.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}