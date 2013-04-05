/**
 * 
 */
package beStrong.oneDay;

/**
 * @author Administrator
 *
 */
public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WeekDay1 weekDay1 = WeekDay1.MON;
		System.out.println(weekDay1);
		System.out.println(weekDay1.nextDay());
		WeekDay  weekDay = WeekDay.FRI;
		System.out.println(weekDay);
		System.out.println(weekDay.name());
		System.out.println(weekDay.ordinal());
		System.out.println(WeekDay.valueOf("SUN"));//把一个字符串转变为一个枚举类的一个元素
		System.out.println(WeekDay.values().length);

	}
	
	public enum WeekDay{
		SUN(1),MON(),TUE,WED,THU,FRI,SAT;//构造方法必须放在元素列表之后
		//且构造方法必须为私有的 private
		
	  	private	 WeekDay (){System.out.println("first");}
	  	
	  	private WeekDay(int i){System.out.println("second");}
		}
	
	public enum  Trafficlamp{
		RED(30){
			public Trafficlamp nextLamp(){
				return GREEN;
			}
		},
		GREEN(45){
			public Trafficlamp nextLamp(){
				return YELLOW;
			}
		},
		YELLOW(5){
			public Trafficlamp nextLamp(){
				return RED;
			}
		};
		public abstract Trafficlamp nextLamp();
		
		private int time;
		
		private Trafficlamp(int time){
			this.time=time;
		}
		
	}
	

}
