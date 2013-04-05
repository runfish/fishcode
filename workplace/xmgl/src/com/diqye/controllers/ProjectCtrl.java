package com.diqye.controllers;

import java.util.Date;

import com.diqye.error.process.ErrorInter;
import com.diqye.moudels.Dept;
import com.diqye.moudels.Project;
import com.diqye.moudels.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.util.Ext;
import com.util.U;
import com.util.Where;

@Before(ErrorInter.class)
public class ProjectCtrl extends Controller {

	public void index(){
		setAttr("firstd", U.formartDate(U.getFirstDayOfMonth(new Date())));
		setAttr("lastd", U.formartDate(U.getLastDayOfMonth(new Date())));
		User u = getSessionAttr("user");
		setAttr("userid", u.getInt("Userid"));
		setAttr("username", u.get("Username"));
		Dept d = Dept.get(u.getInt("Dptid"));
		setAttr("deptid", d.getInt("DptID"));
		setAttr("deptname", d.get("DptName"));
		render("/pages/project.html");
	}
	
	public void grid(){
		String where = Where.projectSearchBuilder(getPara("DeptId"), getPara("sdate"), getPara("edate"), getPara("userid"), getPara("pseach"));
		renderJson(Ext.grid(Project.count(where), Project.selectByPage(getParaToInt("start"), getParaToInt("limit"),where)));
	}
	
	public void save(){
		new Project().save(this);
		renderJson(Ext.ok(true, ""));
	}
	
	public void del(){
		new Project().set("Prjid", getPara(0)).delete();
		renderJson(Ext.ok(true, ""));
	}
	
	public void get(){
		renderJson(Project.get(getParaToInt(0)));
	}
	
	public  void update(){
		new Project().update(this);
		renderJson(Ext.ok(true, ""));
	}
}
