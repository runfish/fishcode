/**
 * 
 */
package net.dfrz;

/**
 * @author Administrator
 *
 */
public class Apple {
	
	private String color;
	private String weight;
	
	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Apple(String color, String weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("调用equals方法");
		if (!(obj instanceof Apple)) return false;
		Apple otherApple =(Apple)obj;
		return this.color.equals(otherApple.getColor())&&this.weight.equals(otherApple.getWeight());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println("调用hashCode方法");
		return this.color.hashCode()+this.weight.hashCode();
	}

	

}
