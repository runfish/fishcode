package com.util;

import com.jfinal.kit.StringKit;

public class Where {

	/**
	 * select * from (select u.*, d.DptName, d.ViewOrder from Bas_userinfo u inner join Bas_DptList d on (u.Dptid = d.DptId)) where substr(ViewOrder,1,2) = '01'  and Username like '%秦振龙%'  order by Userid desc limit ?,?
	 * @param under 是否包含下级
	 * @param unsearch 用户名
	 * @param order 排序号
	 * @return
	 */
	public static String userBulider(boolean under, String unsearch, String order){
		StringBuffer sb = new StringBuffer();
		boolean flag = true;
		if(!("".equals(order))){
			flag = false;
			if((order.length()&1)==1)under = false;
			int length = order.length();
			if(under) sb.append("where substr(ViewOrder,1,").append(length).append(") = '").append(order).append("' ");
			else sb.append(" where ViewOrder = '").append(order).append("' ");
		}
		
		if(!("".equals(unsearch))){
			if(flag)sb.append(" where Username like '%").append(unsearch).append("%' ");
			else sb.append(" and Username like '%").append(unsearch).append("%' ");
		}
		return sb.toString();
	}
	
	public static String projectSearchBuilder(String deptid, String sdate, String edate, String userid, String psearch){
		StringBuffer sb = new StringBuffer();
		WhereOrAnd woa = new WhereOrAnd();
		if(nb(deptid)){
			sb.append(woa).append("Dptid = ").append(deptid).append(" ");
		}
		
		if(nb(userid)){
			sb.append(woa).append("Userid = ").append(userid).append(" ");
		}
		
		if(nb(sdate)){
			sb.append(woa).append("Creatdate >= '").append(sdate).append("' ");
		}
		
		if(nb(edate)){
			sb.append(woa).append("Creatdate <= '").append(edate).append("' ");
		}
		
		if(nb(psearch)){
			sb.append(woa).append("PrjCode like '%").append(psearch).append("%' ");
		}
		return sb.toString();
	}
	
	public static boolean nb(String s){
		return !(StringKit.isBlank(s));
	}
	
	public static class WhereOrAnd{
		private boolean iswhere = true;
		@Override
		public String toString(){
			if(iswhere){
				iswhere = false;
				return " where ";
			}
			
			return " and ";
		}
	}
}
