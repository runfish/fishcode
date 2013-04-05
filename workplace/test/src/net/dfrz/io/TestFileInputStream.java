package net.dfrz.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.BufferOverflowException;

public class TestFileInputStream {
	

	public static void main(String[] args) {
		 int b = 0;
		FileInputStream in= null;
		FileOutputStream out = null;
		BufferedInputStream bf  = null;
		BufferedOutputStream bo = null;
		try {
			in = new FileInputStream("F:/歌曲/林俊杰-江南.mp3");
		    bf = new BufferedInputStream(in);
			out = new FileOutputStream("f:/xiaoyu.mp3");
		    bo = new BufferedOutputStream(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件没有找着");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count=0;
		try {
			while((b=bf.read())!=-1){
				//System.out.print((char)b);
				bo.write(b);
				count++;
			}
			
			in.close();
			out.flush();
			out.close();
			System.out.println("文件已经复制");
			System.out.println();
			System.out.println(count);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	

}
