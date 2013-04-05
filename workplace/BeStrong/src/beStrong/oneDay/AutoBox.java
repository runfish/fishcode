/**
 * 
 */
package beStrong.oneDay;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class AutoBox {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer  integer = 3;
		Integer  integer2 = 3;
		System.out.println(integer==integer2);
		System.out.println(integer + 2);
		
		String string = new String("abc");
		String string2 = "abc";
		System.out.println(string==string2);
		/**
		 * true
           5
           false
        */
		Integer  integer3 = 153;
		Integer  integer4 = 3;
		System.out.println(integer3==integer4);//false   
		
		//享元设计模式 flyweight
		//有一些很小的对象，他们的很多属性相同  把他们封装为一个对象
		//相同的属性为对象的内部属性 不同的地方作为外部方法的参数进行传递

	}

}
