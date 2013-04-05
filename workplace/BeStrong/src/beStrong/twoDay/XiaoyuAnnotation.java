package beStrong.twoDay;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import beStrong.oneDay.EnumTest;


@Retention(RetentionPolicy.RUNTIME)//这个称为元注解


/**
 * resource
 * 
 */

/**
 * 这个注解表示的意思是这个注解需要保持到程序运行的时候
 * 一个是编译的时候称为class文件    注解分为三个阶段  默认值是在class阶段//源文件     class文件    内存字节码阶段
 * 一个是class文件加载到内存中需要文件转换字节码
 * 
 */
@Target({ElementType.METHOD,ElementType.TYPE})//这就是属于数组类型
/**
 * 这个元注解指明了此注解能用在某个类的某个后者某些成分上  比如  一个类的 字段   方法  类上等
 */
public @interface XiaoyuAnnotation {
	
	String color() default "red";//这就是注解的属性表示方式 就好像接口里的方法
	
	String value();
	/**
	 * 如果只有一个value属性需要设置的时候 就可以直接在调用注解的时候填值
	 * 如果出了value属性还有其他属性
	 * 要达到直接填写value属性的值就需要把其他属性设置一个默认的值
	 */
	/**
	 * 制定一个数组的属性
	 */

	
	/**
	 * 如果数组只有一个值java提供一个简便方式就是 array = 1   属性值部分可以省略大跨好
	 */
	int[] array();
	
	//枚举类型
	
	EnumTest.Trafficlamp lamp() default  EnumTest.Trafficlamp.RED;
	
	/**
	 * 注解类型
	 */
	
	MethAnnotation annotation () default  @MethAnnotation("xiaoyu");
	
	/**
	 * 注解的返回类型只可以是八种基本类型 和class类型  枚举  数组还有
	 */
	
}
