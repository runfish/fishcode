/**
 * 
 */
package beStrong.twoDay;

import java.util.Date;



/**
 * @author Administrator
 *
 */
public class ClassLoderTest {

	/**
	 * @param args
	 */
	/**
	 * �������
	 * 1.bootStrap    ���ص�����jre���µ�tr.jar
	 * 2.ExtClassLoder ���ص�����JRE/lib/ext/*.jar
	 * 3.AppClassLoder ���ص�����classPathָ��������jar��Ŀ¼
	 * 
	 * 
	 * ���������ί�л���
	 * �����������������ļ��������� ֪������������  ������ز��� ���������������
	 * ����Ƶ������߻�û���ҵ��࣬�Ͳ����ټ�������ֱ���׳��쳣
	 * 
	 * �Լ�д���������Ԥ��֪ʶ
	 * �Լ�д�����������Ҫ�̳�ClassLoder  ÿ�������������һ������ ���ܹҵ�java������������������
	 * findClass������������û�ҵ����ֱ�ӵ����Լ�д����������findClass
	 * ����ֻҪƾ����findClass���� ���� ������������Լ����ķ���
	 * ����������ָ��ඨ�壡ϸ�ڿ������Լ�ʵ��  
	 * ���ܸ���loadClass()�ķ��� ��Ϊ�����������������˿�������
	 * ����-��classLoad-��findClass-���õ�class�ļ���ת��Ϊ�ֽ���--��definClass()
	 * 
	 */
	
	/**
	 * 
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ClassLoderTest.class.getClassLoader().getClass().getName());
		System.out.println(System.class.getClass().getName());//�����getClassLoderΪnull  ����������û��������� ֻ������һ��������������
        //System���������bootstrop����������ص�
		
		ClassLoader classLoader = ClassLoderTest.class.getClassLoader();
		while(classLoader !=null){
			System.out.println(classLoader.getClass().getName());
			classLoader = classLoader.getParent();
		}
		System.out.println(classLoader);
		
		//System.out.println(new ClassLoaderAtt().toString());
		
       Class clazz = new MyClassLoderTest("xiaoyulib").loadClass("ClassLoaderAtt");
       Date d1 =(Date)clazz.newInstance();
       System.out.println(d1);
		
	}

}
