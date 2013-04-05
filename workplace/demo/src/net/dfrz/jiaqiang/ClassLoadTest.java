package net.dfrz.jiaqiang;

public class ClassLoadTest {
	
	public  static void main(String [] agrs){
		
		System.out.println(ClassLoad.class.getClassLoader().getClass().getName());
		System.out.println(System.class.getClassLoader());
	}

}
