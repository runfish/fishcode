/**
 * 
 */
package beStrong.oneDay;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

/**
 * @author Administrator
 *
 */
public class ReflectTest2 {

	/**
	 * @param args
	 */
	
	/**
	 * С��ܵĽ���Ӧ��
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//һ��Ҫ��ס�ļ�������·�� ������·������Ӳ���� ���Ǽ�������
		//InputStream ips = new FileInputStream("config.properties");//����Ǹ����·�����ļ�
		//��Ҫ�ļ��ľ���·��getRealPath();
		//ʹ����������ṩ�ķ���������ͨ�ļ����ڴ�
		//InputStream ips = ReflectTest2.class.getClassLoader().getResourceAsStream("beStrong/oneDay/config.properties");
		                   //�����ǻ�ȡ�������                                            //besStrongǰ�����Լ�/
		//InputStream ips =ReflectTest2.class.getResourceAsStream("config.properties");
		//InputStream ips =ReflectTest2.class.getResourceAsStream("resource/config.properties");
		
		//��������ļ������ͬ��һ������ �����ʹ�����·��// �������ڸ�������Ӱ����������ļ���Ǯ�����Ӱ���·����ok
		
		InputStream ips =ReflectTest2.class.getResourceAsStream("/beStrong/oneDay/resource/config.properties");
		//����·����ҪЩ������·��
		
		Properties props = new Properties();
		props.load(ips);
		ips.close();
		/**
		 * ips.closeֻ���ͷ�ϵͳ��Դ ��û���������� ips���
		 * ��������java���������ͳһ������
		 */
		String className = props.getProperty("className");
		Collection collection = (Collection)Class.forName(className).newInstance();
		
		RefectPoint pt1 = new RefectPoint(3,5);
		RefectPoint pt2 = new RefectPoint(3,3);
		RefectPoint pt3 = new RefectPoint(3,5);
	
		//û�и���hashcode�ķ����Ļ������н����3Ҳ�п�����2
		//ǰ���ǹ�ϣ����
		//ÿһ�����󶼻���һ����Ӧ�Ĺ�ϣcode��ֵ ���ݲ�ͬ��ֵ�����һ������
		//��һ��������ڹ�ϣ�����оͲ�Ҫ�޸Ķ������ϲ����ϣ������ֶ�
		collection.add(pt1);
		collection.add(pt2);
		collection.add(pt3);
		collection.add(pt1);
		
	    //pt1.name = 12;
		//collection.remove(pt1);
		/**
		 * ���������ڴ�й¶ ����ٴ��������޸Ķ�������ϣֵ������ֶ��������ڴ�й¶
		 * ������󽫻��������  ����ɾ��
		 * 
		 */
		System.out.println(collection.size());

	}

}