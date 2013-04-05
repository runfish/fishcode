/**
 * 
 */
package beStrong.oneDay;

/**
 * @author Administrator
 *
 */
public class RefectPoint {
	
	
	private int color;
	
	public int name;
	
	public String age = "abcfdbaba";
	
	public String sex = "abbbaabsdfab";

	public RefectPoint(int color, int name) {
		super();
		this.color = color;
		this.name = name;
	}

	public RefectPoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + color;
		result = prime * result + name;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final RefectPoint other = (RefectPoint) obj;
		if (color != other.color)
			return false;
		if (name != other.name)
			return false;
		return true;
	}

}
