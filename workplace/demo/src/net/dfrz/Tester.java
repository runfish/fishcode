/**
 * 
 */
package net.dfrz;

import java.util.HashSet;

import sun.awt.geom.AreaOp.AddOp;

/**
 * @author Administrator
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<Apple> apple = new HashSet<Apple>(); 
		
		apple.add(new Apple("red","60"));
		apple.add(new Apple("red","60"));
		
		System.out.println(apple.size());
		System.out.println(add(23,34));

	}
	
	public static int add(int x,int... agrs){
		int sum = x;
		for(int i=0;i<agrs.length;i++){
			sum +=agrs[i];
		}
		
		return sum;
		
	}
	
	public enum WeekDay{
		Sun,Mon,Tue,Wed;
		
		private WeekDay() {
		}
		private  WeekDay(int day) {
			
		}
		
	}

}
