/**
 * 
 */
package net.dfrz;

/**
 * @author Administrator
 *
 */
public class ReflectPoint {
	private int x;
	public int y;
  
	public String str1 ="abc";
	public String str2 = "basketball";
	public String str3 = "dfrz";
	
	public ReflectPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.str1+this.str2+this.str3;
	}
	
	
	

}
