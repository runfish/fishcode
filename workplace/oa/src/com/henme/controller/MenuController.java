package com.henme.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.henme.ext.DwzRender;
import com.henme.model.Menu;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;

public class MenuController extends Controller {
	private static String navTabId="menu";
	
	public void index2() {
		this.setAttr("list", Db.find("select id,pid,name 名称,url 链接,type 类别,menulevel 级别,ordernum 排序,safecode 安全码 ,icon 图标,enable 状态  from  menu  order by ordernum asc,menulevel asc"));
		this.setAttr("collist", new String[]{"名称","类别","级别","链接","排序","安全码","图标","状态"});
		render("index2.html");
	}
	
	public void index() {
		this.setAttr("list", Db.find("select id,pid,name 名称,url 链接,type 类别,menulevel 级别,ordernum 排序,safecode 安全码 ,icon 图标,enable 状态  from  menu  order by ordernum asc,menulevel asc"));
		this.setAttr("collist", new String[]{"名称","类别","级别","链接","排序","安全码","图标","状态"});
		render("index.html");
	}

	public void enable(){
		Record menu=Db.findById("menu", getParaToLong(0, 0L));
		int newvalue=menu.getInt("enable")==1?0:1;
		menu.set("enable", newvalue);
		Db.update("menu", menu);
		render(DwzRender.success(newvalue==0?"禁用成功":"启用成功",navTabId));
	}
	
	@Before(Tx.class)
	public void move() {
		Long id=this.getParaToLong(0, 0L);
		Long val=this.getParaToLong(1, 0L);
		Long nextid=this.getParaToLong(2, 0L);
		Long nextval=this.getParaToLong(3, 0L);
		Db.update("update menu set ordernum=? where id=?",nextval,id); 
		Db.update("update menu set ordernum=? where id=?",val,nextid); 
		render(DwzRender.success("移动成功！",navTabId));
	}
	
	public void save() {
		Menu model = getModel(Menu.class);
		if (model.getLong("id") == null) {
			model.save();
		} else {
			model.update();
		}
		render(DwzRender.closeCurrentAndRefresh("menu"));
	}
	
	public void child(){
		Menu menu=new Menu();
		menu.set("pid", getParaToInt(0));
		setAttr("menu", menu);
		render("add.html");
	}
	
	public void add() {
		int id = getParaToInt(0,0);
		Menu menu = Menu.dao.findById(id);
		if (id == 0) {
			menu = new Menu();
		} else if (menu == null) {
			render(DwzRender.error("该记录已被删除，请您先刷新列表"));
		}
		setAttr("menu", menu);
	}
	
	/**
	 * 递归查询
	 */
	public void del() {		
		List<Long> s=new ArrayList<Long>();
		s=getchildrenId(2L,s);
		Db.query("delete from menu where id in (?)",StringUtils.join(s, ","));
		render(DwzRender.success("删除成功！",navTabId));
	}
	
	public  List<Long> getchildrenId(Long pid,List<Long> s){
		List<Record> list=getchildren(pid);
		Long id;//子id
		for(Record r:list){
			id=r.getLong("id");
			s.add(id);
			if(getchildren(id).size()>0){
				getchildrenId(id,s);
			}
		}
		return s;
	}
	
	public  List<Record> getchildren(Long pid){
		return Db.find("select id from menu where pid=?",pid);
	}
}
