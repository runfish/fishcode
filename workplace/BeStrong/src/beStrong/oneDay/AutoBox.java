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
		
		//��Ԫ���ģʽ flyweight
		//��һЩ��С�Ķ������ǵĺܶ�������ͬ  �����Ƿ�װΪһ������
		//��ͬ������Ϊ������ڲ����� ��ͬ�ĵط���Ϊ�ⲿ�����Ĳ������д���

	}

}
