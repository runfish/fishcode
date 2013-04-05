package com.diqye.moudels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.server.ssl.SslCertificates;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.moudel.ext.SqliteModel;

public class Project extends SqliteModel<Project>{
	static Project  p = new Project();
	static final String view = " (select a.*,u.Username as \"Username\" from (select p.*,d.DptName from Info_prjvalues p inner join Bas_DptList d on (p.Dptid = d.DptID)) a inner join Bas_userinfo u on (a.Userid = u.Userid) order by Prjid desc) ";
	public static int count(String where){
		
		Record r = Db.findFirst("select count(*) cun from "+view+" " + where);;
		return r.getInt("cun");
	}
	
	public static List<Map> selectByPage(int start, int page,String where){
		List<Map> lr = new ArrayList<Map>(page);
		List<Record> recs = Db.find("select * from " + view+ " " + where + " limit ?,?",start,page);
		for(Record r : recs){
			lr.add(r.getColumns());
		}
		
		return lr;
	}
	
	public void save(Controller c){
		this.set("PrjCode", c.getPara("PrjCode"))
		.set("Dptid", c.getPara("Dptid"))
		.set("Userid", c.getPara("Userid"))
		.set("Creatdate", c.getPara("Creatdate"))
		.set("Amount", Double.valueOf(c.getPara("Amount")))
		.set("note", c.getPara("note"))
		.save();
	}
	
	public static Project get(int id){
		return p.findById(id);
	}

	public void update(Controller c) {
		this.set("PrjCode", c.getPara("PrjCode"))
		.set("Prjid",c.getPara("Prjid"))
		.set("Dptid", c.getPara("Dptid"))
		.set("Userid", c.getPara("Userid"))
		.set("Creatdate", c.getPara("Creatdate"))
		.set("Amount", Double.valueOf(c.getPara("Amount")))
		.set("note", c.getPara("note"))
		.update();
	}
}
