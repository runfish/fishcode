package beStrong.twoDay;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import beStrong.oneDay.EnumTest;


@Retention(RetentionPolicy.RUNTIME)//�����ΪԪע��


/**
 * resource
 * 
 */

/**
 * ���ע���ʾ����˼�����ע����Ҫ���ֵ��������е�ʱ��
 * һ���Ǳ����ʱ���Ϊclass�ļ�    ע���Ϊ�����׶�  Ĭ��ֵ����class�׶�//Դ�ļ�     class�ļ�    �ڴ��ֽ���׶�
 * һ����class�ļ����ص��ڴ�����Ҫ�ļ�ת���ֽ���
 * 
 */
@Target({ElementType.METHOD,ElementType.TYPE})//�����������������
/**
 * ���Ԫע��ָ���˴�ע��������ĳ�����ĳ������ĳЩ�ɷ���  ����  һ����� �ֶ�   ����  ���ϵ�
 */
public @interface XiaoyuAnnotation {
	
	String color() default "red";//�����ע������Ա�ʾ��ʽ �ͺ���ӿ���ķ���
	
	String value();
	/**
	 * ���ֻ��һ��value������Ҫ���õ�ʱ�� �Ϳ���ֱ���ڵ���ע���ʱ����ֵ
	 * �������value���Ի�����������
	 * Ҫ�ﵽֱ����дvalue���Ե�ֵ����Ҫ��������������һ��Ĭ�ϵ�ֵ
	 */
	/**
	 * �ƶ�һ�����������
	 */

	
	/**
	 * �������ֻ��һ��ֵjava�ṩһ����㷽ʽ���� array = 1   ����ֵ���ֿ���ʡ�Դ���
	 */
	int[] array();
	
	//ö������
	
	EnumTest.Trafficlamp lamp() default  EnumTest.Trafficlamp.RED;
	
	/**
	 * ע������
	 */
	
	MethAnnotation annotation () default  @MethAnnotation("xiaoyu");
	
	/**
	 * ע��ķ�������ֻ�����ǰ��ֻ������� ��class����  ö��  ���黹��
	 */
	
}
