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
	@SuppressWarnings("deprecation")//这个注解是告诉开发工具 编译器 
	//一个注解就是一个类  这里就相当于一个注解的一个对象
	//@XiaoyuAnnotation
	public static void main(String[] args) {//mian 方法虽然属于某个类但是main方法是不属于这个类的
		// TODO Auto-generated method stub
		System.runFinalizersOnExit(true);//deprecate 过时
		if(AnnotationTest.class.isAnnotationPresent(XiaoyuAnnotation.class)){
			//此时注解值存在class阶段当在内存中是就不存在注解了
			
			XiaoyuAnnotation annotation = (XiaoyuAnnotation)AnnotationTest.class.getAnnotation(XiaoyuAnnotation.class);
			System.out.println(annotation);
			
			System.out.println(annotation.color());
			
			System.out.println(annotation.value());
			System.out.println(annotation.array().length);
			
			System.out.println(annotation.lamp());
			
		
			System.out.println(annotation.annotation().value());
		}//这个方法是用来检查这个类是否有用到某个注解类

	}
	@Deprecated
	public static void sayHellow(){
		System.out.println("你好小鱼！");
	}

}
