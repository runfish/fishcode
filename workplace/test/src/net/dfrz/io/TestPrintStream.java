package net.dfrz.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestPrintStream {

	
	public static void main(String[] args) {
		
		PrintStream ps = null;
		
		try {
			FileOutputStream fos = new FileOutputStream("f:/xiaoyu.txt");
			ps = new PrintStream(fos);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ps!=null){
			System.setOut(ps);
		}
		
		int cnt = 0;
		for(char c=0;c<60000;c++){
			System.out.print(c+" ");
			if(cnt++>=100){
				System.out.println();
				cnt = 0;
			}
		}
		
	}
}
