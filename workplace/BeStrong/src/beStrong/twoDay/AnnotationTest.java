/**
 * 
 */
package beStrong.twoDay;


/**
 * @author Administrator
 *
 */
@XiaoyuAnnotation(value="abc",array={2,3,4})
public class AnnotationTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")//���ע���Ǹ��߿������� ������ 
	//һ��ע�����һ����  ������൱��һ��ע���һ������
	//@XiaoyuAnnotation
	public static void main(String[] args) {//mian ������Ȼ����ĳ���൫��main�����ǲ�����������
		// TODO Auto-generated method stub
		System.runFinalizersOnExit(true);//deprecate ��ʱ
		if(AnnotationTest.class.isAnnotationPresent(XiaoyuAnnotation.class)){
			//��ʱע��ֵ����class�׶ε����ڴ����ǾͲ�����ע����
			
			XiaoyuAnnotation annotation = (XiaoyuAnnotation)AnnotationTest.class.getAnnotation(XiaoyuAnnotation.class);
			System.out.println(annotation);
			
			System.out.println(annotation.color());
			
			System.out.println(annotation.value());
			System.out.println(annotation.array().length);
			
			System.out.println(annotation.lamp());
			
		
			System.out.println(annotation.annotation().value());
		}//����������������������Ƿ����õ�ĳ��ע����

	}
	@Deprecated
	public static void sayHellow(){
		System.out.println("���С�㣡");
	}

}
