/**
 * 
 */
package beStrong.oneDay;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * @author Administrator
 *
 */
public class RefectTest {

	private static final String Object = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		String str = "abc";
		Class class1 = str.getClass();
		Class class2 = String.class;
		Class class3 = Class.forName("java.lang.String");
		System.out.println(class1==class2);
		System.out.println(class2==class3);
		System.out.println(class1==class3);
		
		System.out.println(class1.isPrimitive());//�жϴ˷��ֽ����Ƿ�Ϊԭʼ����
		System.out.println(int.class.isPrimitive());
		System.out.println(Integer.class.isPrimitive());
		System.out.println(int.class == Integer.class);
		System.out.println(int.class == Integer.TYPE);//integet.type ��ʾ�˰�װ��������װ���Ǹ��������͵��ֽ���
		System.out.println(int[].class.isPrimitive());
		System.out.println(int[].class.isArray());//�������͵�ʵ���������õķ����� isArray
		//��ֻ֮Ҫ����Դ�����г��ֵ����Ͷ��и��Ե�classʵ������ eg  �� int����  void ��
		
		// ������ǰ�һ��java���ϵ����гɷ�ӳ���һ����java��
		//new String(new StringBuffer());
		Constructor constructor = String.class.getConstructor(StringBuffer.class);//���ĳһ���췽����Ҫ�õ����Ͷ���
		                                                           
		
		String string = (String)constructor.newInstance(new StringBuffer("abc"));//newInstance ���ص���һ��object�Ķ��� ��Ҫ�������ǿ������װ��
		//�ϸ����ֱ��������еĲ�ͬ
		
		//��Ҫnewһ�����������Ĺ��췽���Ķ��� ֱ�ӾͿ���Class.newInstance
		String.class.newInstance();
		

		System.out.println(string.charAt(2));
		
		
//		//RefectPoint pt1 = new RefectPoint("red","xiaoyu");
//	    Field field = pt1.getClass().getField("name");//name �ֶ������ǹ��е� public
//	    System.out.println( field.get(pt1));
//	    Field field2 = pt1.getClass().getDeclaredField("color");//�����color���� Ϊ˽��  
//	    field2.setAccessible(true);//����Ҫ������ֵ  ����Ϊ���Է���  �ųƱ�������
//	    System.out.println( field2.get(pt1));
//	    
//	    changeStringvalue( pt1);
	    
	    Method methodCharAtMethod = String.class.getMethod("charAt", int.class);
	    System.out.println(methodCharAtMethod.invoke(str, 2));//������õ��Ǿ�̬����
	    //��str�����д��nulll��
	    System.out.println(methodCharAtMethod.invoke(str, new Object []{2}));
	    
	    //TextArguments.main(new String[]{"123","xiaoyu","hehe"});
	    //Ϊʲô Ҫ�÷���ķ�ʽ����
	    
	    String  className = args[0];
	    Method mainMethod = Class.forName(className).getMethod("main", String[].class);
	    mainMethod.invoke(null, new Object[]{new String[]{"123","2345","xiaoyu"}});//�����Ȼ���  ���ֱ�����ַ�������Ļ��ͻ���Ϊ������n������  ������Ҫ���Ϊһ��object���͵Ķ���
	    //����ȥ ���Ż��Զ����  �����еڶ��ַ��� ����ֱ�Ӱ��ַ������������ǿ������ת��Ϊobject���;�ok
	    
	    int [] a1 = new int[]{1,2};
	    int [] a2 = new int[3];
	    int [][] a3 = new int [2][3];
	    String [] a4 = new String[]{"zx","asd","sdsd"};
	    System.out.println(a1.getClass()==a2.getClass());//ע������Ƚϵ�����������������Ӧ���ֽ���  �����Ƕ���
	    System.out.println(a1.getClass()==a3.getClass());
	    System.out.println(a1.getClass()==a4.getClass());
	    System.out.println(a1.getClass().getName());
	    System.out.println(a3.getClass().getName());
	    System.out.println(a1.getClass().getSuperclass().getName());
	    System.out.println(a4.getClass().getSuperclass().getName());
	    
	    Object object1 = a1;//�������Ͳ���object������ object����װ����int���͵�����
	    Object object2 = a2;
	    Object object3[] = a3;//int[]������object����
	    Object object4 = a4; //String Ҳ��object������
	    System.out.println(a1);
	    System.out.println(a4);//������ӡ���Ľ��ֻ�Ƕ���Ĺ�ϣcode
	    System.out.println(Arrays.asList(a1));//Arrays��һ����������յ���һ��object������
	    //String���͵����鰴jdk1.4�ķ�ʽ�����Ч�ڶ��Ԫ�� 
	    //a1�ǲ���object������ ���ԾͰ�jdk1.5�ķ������д��� ����һ��Ԫ�ش���
	    System.out.println(Arrays.asList(a4));
	    
	    //��������������з���
	    
	    printObject(a4);
	    printObject(a1);
	
	}

	private static void printObject(Object obj) {
		// TODO Auto-generated method stub
		Class  clazz = obj.getClass();
		if(clazz.isArray()){
			int len = Array.getLength(obj);
			for(int i=0;i<len;i++){
				System.out.println(Array.get(obj, i));
				System.out.println(Array.get(obj, i).getClass().getName());
			}
			
		}
		else{
			System.out.println(obj);
		}
		
	}

	private static void changeStringvalue(Object obj)throws Exception {
		// TODO Auto-generated method stub
		Field field[] = obj.getClass().getFields();
		
		for(Field f : field){
			if(f.getType() == String.class){//���ﶼֻ��һ���ֽ��� �����õȺ�
				String oldValue = (String)f.get(obj);
				
				String newValue = oldValue.replace('a', 'b');
				f.set(obj, newValue );//�����޸ĺ���ֶ��������õ��ֶ���
				System.out.println(f.get(obj));
			}
		}
		
	}
	
}

class TextArguments{
	
	public static void main(String [] agrs){
		for(String agr : agrs){
			System.out.println(agr);
		}
	}
}
