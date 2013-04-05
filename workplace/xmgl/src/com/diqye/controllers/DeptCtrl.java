package com.diqye.controllers;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import org.apache.log4j.Logger;

import com.diqye.error.XmglException;
import com.diqye.error.process.ErrorInter;
import com.diqye.moudels.Dept;
import com.diqye.moudels.Project;
import com.diqye.moudels.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.StringKit;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.util.Ext;

@Before(ErrorInter.class)
public class DeptCtrl extends Controller {

	Logger log = Logger.getLogger(getClass());
	public void index(){
		render("/pages/dept.html");
	}
	
	//树形菜单数据
	public void tree(){
		log.debug(JsonKit.toJson(getParaMap()));
		
		renderJson(Dept.treeForExt(getPara("node")));
	}
	
	//单位详细信息
	public void doAction(){
		Dept dept = Dept.getByOrder(getPara(0));
		log.debug(dept.toJson());
		renderJson(Ext.doAction(dept));
	}
	
	//添加同级
	public void addSameDept(){
		
		Dept dept = new Dept();
		if(dept.save(this))renderJson(Ext.ok(true, ""));
		else renderJson(Ext.ok(false, "保存数据失败"));
		
	}
	
	//添加下级
	//@Before(Tx.class)//事务支持 sQL lite 不支持
	public void addUnderDept(){
		
		Dept dept = new Dept();
		if(dept.saveUnder(this))renderJson(Ext.ok(true, ""));
		else renderJson(Ext.ok(false, "保存数据失败"));
		
	}
	
	public void update(){
		Dept d = Dept.get(getParaToInt("DptID"));
		d.set("DptCode", getPara("DptCode"))
		.set("DptName", getPara("DptName"))
		.set("DptBriefName", getPara("DptBriefName"))
		.set("DptClass", getPara("DptClass"))
		.set("DptType", getPara("DptType"))
		.update();
		
		renderJson(Ext.ok(true, ""));
	}
	
	public void del(){
		String order = getPara(1);
		if((order.length()&1)!= 1){
			throw new XmglException("请先删除子单位");
		}
		Dept d = Dept.get(getParaToInt(0));
		java.util.List<User>  us = d.getUser();
		log.debug("us.size == " + us.size());
		if(us != null && us.size() !=0 ){ //此处可以使用 SQL count(*) 由于时间关系 故写成这样 下面雷同
			throw new XmglException("该单位关联用户 不允许删除");
		}
		java.util.List<Project>  ps = d.getProject();
		if(ps != null && ps.size() != 0)throw new XmglException("该单位关联的有项目 不允许删除");
		
		Dept pd = d.getParent();
		d.delete();
		pd.smarkleaf();
		renderJson(Ext.ok(true, ""));
	}
	
	public void users(){
		Dept d = new Dept();
		if(StringKit.isBlank(getPara("did"))){
			d.set("DptID", 1);	
		}else{
			d.set("DptID", getParaToInt("did"));
		}
		renderJson(Ext.combobox(d.getUser()));
	}
}
