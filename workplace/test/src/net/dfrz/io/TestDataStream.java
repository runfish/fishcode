package net.dfrz.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class TestDataStream {
	
	public static void main(String[] args) {
		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		
		DataOutputStream dop = new DataOutputStream(bis);
		try {
			dop.writeDouble(Math.random());
			dop.writeBoolean(true);
			
			ByteArrayInputStream bos = new ByteArrayInputStream(bis.toByteArray());
			DataInputStream dis = new DataInputStream(bos);
			System.out.println(bos.available());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			
			dis.close();
			
			dop.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
