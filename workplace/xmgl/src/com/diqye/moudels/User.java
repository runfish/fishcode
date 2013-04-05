package com.diqye.moudels;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.TableInfo;
import com.jfinal.plugin.activerecord.TableInfoMapping;
import com.moudel.ext.SqliteModel;
import com.util.U;

import freemarker.template.SimpleDate;

public class User extends SqliteModel<User>{
	static User u = new User();
	static Logger log = Logger.getLogger(u.getClass());
	public User(){}
	
	public static User Login(String name,String password){
		return u.findFirst("select * from Bas_userinfo where LogonName=? and Password=?",name,password);
	}
	
	public static boolean checkLoginName(String loginName){
		Record r = Db.findFirst("select count(*) _count from Bas_userinfo where LogonName=?",loginName);
		long rl = r.getInt("_count");
		log.debug("验证用户登陆["+loginName+"]返回结果：" + rl);
		return rl > 0;
	}
	
	public static List<Map> selectByPage(int start, int page,String where){
		List<Map> lr = new ArrayList<Map>(20);
		List<Record> recs = Db.find("select * from (select u.*, d.DptName, d.ViewOrder from Bas_userinfo u inner join Bas_DptList d on (u.Dptid = d.DptId) order by Userid desc ) "+where+" limit ?,?",
				start,page);
		for(Record r : recs){
			lr.add(r.getColumns());
		}
		
		return lr;
	}
	
	public static int count(String where){
		Record r = Db.findFirst("select count(*) cun from (select * from (select u.*, d.DptName, d.ViewOrder from Bas_userinfo u inner join Bas_DptList d on (u.Dptid = d.DptId)) "+where+")");
		return r.getInt("cun");
	}
	
	public  void save(Controller c) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		this.set("LogonName", c.getPara("LogonName"))
		.set("Username", c.getPara("Username"))
		.set("Password", c.getPara("Password"))
		.set("Dptid", c.getParaToInt("Dptid"))
		.set("Sex", c.getPara("Sex"))
		//.set("Birthday", "".equals(c.getPara("Birthday")) ? null : U.toSqlDate(sdf.parse(c.getPara("Birthday")) ))
		.set("Birthday", c.getPara("Birthday"))
		.set("Bphone", c.getPara("Bphone"))
		.set("Headship", c.getPara("Headship"))
		.set("note", c.getPara("note"))
		.save();
	}
	
	public List<Project> getProject(){
		return Project.p.find("select * from Info_prjvalues where Userid = ?",this.get("Userid"));
	}
	
	public static User get(int id){
		return u.findById(id);
	}
	
	public static void update(Controller c){
		u.set("Userid", c.getParaToInt("Userid"))
		.set("LogonName", c.getPara("LogonName"))
		.set("Username", c.getPara("Username"))
		.set("Password", c.getPara("Password"))
		.set("Dptid", c.getPara("Dptid"))
		.set("Sex", c.getPara("Sex"))
		.set("Birthday", c.getPara("Birthday"))
		.set("Bphone", c.getPara("Bphone"))
		.set("Headship", c.getPara("Headship"))
		.set("note", c.getPara("note"))
		.update();
	}
	
	
}
