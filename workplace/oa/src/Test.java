import java.util.Date;
import java.util.Random;


class XX{
	public static final int i=new Random().nextInt(11);
	static{
		System.out.println("init static block");
	}
	
}
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(XX.i);
		long i=1;
		Long i1=1L;
		Long j=1l;
	//	System.out.println(new Date() instanceof String);
	}
	
	
}
