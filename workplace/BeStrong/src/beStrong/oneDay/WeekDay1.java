/**
 * 
 */
package beStrong.oneDay;

/**
 * @author Administrator
 *
 */
public abstract class WeekDay1 {
	
	private WeekDay1 (){
		
	}

	//��������������� ʹ���ڲ���
	//�� next�����еĴ����if else ���ת��Ϊһ������������
	public final static WeekDay1 SUN = new WeekDay1(){

		@Override
		public WeekDay1 nextDay() {
			// TODO Auto-generated method stub
			return MON;
		}
		
	};
	public final static WeekDay1 MON = new WeekDay1(){

		@Override
		public WeekDay1 nextDay() {
			// TODO Auto-generated method stub
			return SUN;
		}
		
	};
	
	public abstract WeekDay1 nextDay();
	/**
	 * 
	
	public WeekDay1 nextDay(){
		if(this == SUN)
			return MON;
		else
			return SUN;
	}
	 * @return
	 */

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return this==SUN?"SUN":"MON";
	}
	
	
	
}
