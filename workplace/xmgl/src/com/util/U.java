package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class U {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	public static String formartDate(java.util.Date d){
		String r = sdf.format(d);
		return r;
	}
	
	public static java.util.Date parse(String yyyMMdd){
		try {
			return sdf.parse(yyyMMdd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String formartDate(java.sql.Date d){
		String r = sdf.format(d);
		return r;
	}
	
	public static java.sql.Date toSqlDate(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	
	//获取当前月的最后一天
	public static Date getLastDayOfMonth(Date sDate1) {
	    Calendar cDay1 = Calendar.getInstance();
	    cDay1.setTime(sDate1);
	    final int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
	    Date lastDate = cDay1.getTime();
	    lastDate.setDate(lastDay);
	    return lastDate;
	}
	
	//获取当前月的第一天
	public static Date getFirstDayOfMonth(Date sDate1) {
	    Calendar cDay1 = Calendar.getInstance();
	    cDay1.setTime(sDate1);
	    final int lastDay = cDay1.getActualMaximum(0);
	    Date lastDate = cDay1.getTime();
	    lastDate.setDate(lastDay);
	    return lastDate;
	}
	
	public static void main(String[] args) {
		System.out.println(formartDate(getFirstDayOfMonth(new Date())));
	}
}
