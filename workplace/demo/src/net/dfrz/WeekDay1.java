package net.dfrz;

public abstract class WeekDay1 {

	
	private WeekDay1(){}
	
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
}
