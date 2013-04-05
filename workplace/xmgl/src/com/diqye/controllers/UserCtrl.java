package com.diqye.controllers;

import java.text.ParseException;
import java.util.List;

import com.diqye.error.XmglException;
import com.diqye.error.process.ErrorInter;
import com.diqye.moudels.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.util.Ext;
import com.util.JsonKit2;
import com.util.Where;
@Before(ErrorInter.class)
public class UserCtrl extends Controller {
	public void index(){
		render("/pages/user.html");
	}
	
	public void grid(){
		String order = getPara("DeptId");
		boolean under = getParaToBoolean("under");
		String unsearch = getPara("unseach");
		String where = Where.userBulider(under, unsearch, order);
		renderJson(Ext.grid(User.count(where), User.selectByPage(getParaToInt("start"), getParaToInt("limit"),where)));
	}
	
	//新增用户
	public void save() throws ParseException{
		new User().save(this);
		renderJson(Ext.ok(true, ""));
	}
	
	//删除
	public void del(){
		User u = User.get(getParaToInt(0));
		List ps = u.getProject();
		if(ps != null && ps.size() != 0) throw new XmglException("该用户关联项目，不允许删除");
		u.delete();
		renderJson(Ext.ok(true, ""));
	}
	
	public void doAction(){
		User u = User.get(getParaToInt(0));
		renderJson(Ext.doAction(u));
	}
	
	public void modify(){
		User.update(this);
		renderJson(Ext.ok(true, ""));
	}
	
}
