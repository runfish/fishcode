package com.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moudel.ext.SqliteModel;

public class Ext {

	public static Map doAction(SqliteModel model){
		Map m = new HashMap();
		m.put("success", true);
		m.put("data", model.attrs());
		return m;
	}
	
	public static Map ok(boolean ok, String msg){
		Map m = new HashMap();
		m.put("ok", ok);
		m.put("msg", msg);
		return m;
	}
	
	public static Map grid(int pageCount,List data){
		Map m = new HashMap();
		m.put("results", pageCount);
		m.put("rows", data);
		return m;
	}
	
	public static Map combobox(List models){
		Map m = new HashMap();
		m.put("root", models);
		return m;
	}
}
