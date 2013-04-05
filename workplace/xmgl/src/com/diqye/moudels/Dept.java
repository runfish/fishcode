package com.diqye.moudels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


import com.diqye.error.XmglException;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.moudel.ext.SqliteModel;

public class Dept extends SqliteModel<Dept>{
	static Logger log = Logger.getLogger("dept");
	static Dept d = new Dept();
	
	public static List treeForExt(String node){
		List r = new ArrayList();
		int length = node.length();
		List<Record> lrecord =  Db.find("select DptID,ViewOrder,DptName,DptBriefName from Bas_DptList " +
				"where substr(viewOrder,1,?) = ? and (length(viewOrder) = ? or length(viewOrder) = ?) order by viewOrder"
				,length,node,length+3,length+2);
		for(Record record : lrecord){
			String id = record.getStr("ViewOrder");
			Map<String,Object> m = new HashMap<String,Object>();
			m.put("id", id);
			m.put("leaf", id.length()&1);
			m.put("text", record.getStr("DptName"));
			m.put("qtip", record.getStr("DptBriefName"));
			m.put("DptID", record.getInt("DptID"));
		//	m.put("iconCls", "tree-icon");
			r.add(m);
		}
		return r;
	}
	
	public static Dept getByOrder(String viewOrder){
		//System.out.println("==================" + viewOrder);
		return d.findFirst("select * from Bas_DptList where ViewOrder=?",viewOrder);
	}
	
	public boolean save(Controller controller){
		String deptOrder = controller.getPara("selectDept");
		if(deptOrder == null) {
			throw new XmglException("用户选择的单位为空");
		}
		if(deptOrder.length() >2 ){
			int i = deptOrder.length() -2;//如果长度是奇数 就截去后三位 如果是偶数就截去u后两位
			i -= deptOrder.length()&1;
			String order = deptOrder.substring(0, i);
			this.set("DptName", controller.getPara("DptName"));
			this.set("DptClass", controller.getPara("DptClass"));
			this.set("DptType", controller.getPara("DptType"));
			this.set("DptCode", controller.getPara("DptCode"));
			this.set("DptBriefName", controller.getPara("DptBriefName"));
			this.set("ViewOrder", buildOrder(order));
		}else{
			throw new XmglException("不能再根目录建单位");
		}
		
		return this.save();
	}
	
	public boolean saveUnder(Controller controller){
		String deptOrder = controller.getPara("selectDept");
		if(deptOrder == null) {
			throw new XmglException("用户选择的单位为空");
		}
		//if(deptOrder.length() >2 ){
		
			String order = deptOrder;
			this.set("DptName", controller.getPara("DptName"));
			this.set("DptClass", controller.getPara("DptClass"));
			this.set("DptType", controller.getPara("DptType"));
			this.set("DptCode", controller.getPara("DptCode"));
			this.set("DptBriefName", controller.getPara("DptBriefName"));
			this.set("ViewOrder", buildOrder(order));
		/*}else{
			throw new XmglException("不能再根目录建单位");
		}*/
		
		return (this.save()&&Dept.getByOrder(deptOrder).notleaf());
	}
	private String buildOrder(String superOrder){
		List<Map> l = Dept.treeForExt(superOrder);
		String qz = ((superOrder.length()&1)==1)?superOrder.substring(0,superOrder.length()-1):superOrder;
		
		for(int i = 1;i<100; i++){
			String order = "";
			if(i<10){
				 order = "0" + i;
			}else{
				order = String.valueOf(i);
			}
			
			if(!(contains(l,qz + order))) return qz + order+"l";
		}
		
		throw new XmglException("没有可用的排序号");
	}
	
	private boolean contains(List l,String str){
		for(Object o : l){
			Map m = (Map)o;
			String idstr = (String) m.get("id");
			//System.out.println(idstr + "======" + str);
			if(idstr.equals(str) || idstr.startsWith(str)){
				return true;
			}
		}
		return false;
	}
	public boolean notleaf(){
		String vo = this.getStr("ViewOrder");
		if((vo.length()&1) ==1){
			return this.set("ViewOrder", vo.substring(0, vo.length()-1)).update();
		}
		
		return true;
	}
	
	public boolean leaf(){
		String vo = this.getStr("ViewOrder");
		if((vo.length()&1) ==0){
			return this.set("ViewOrder", vo+"l").update();
		}
		
		return true;
	}
	
	//智能判断自己是 子节点 还是叶子节点
	public void smarkleaf(){
		String vo = this.getStr("ViewOrder");
		if((vo.length()&1) == 1)return ;
		List r = Dept.treeForExt(vo);
		
		log.debug("smarkleaf====" + r.size());
		if(r.size() == 0)this.leaf();
	}
	
	public Dept getParent(){
		String vo = this.getStr("ViewOrder");
		if((vo.length()&1) == 1){
			vo = vo.substring(0,vo.length()-1);
		}
		log.debug("getParent===" + vo);
		return this.findFirst("select * from Bas_DptList where ViewOrder = ? ",vo.substring(0,vo.length()-2));
	}
	
	public static  Dept get(int id){
		log.debug("get====" + id);
		return d.findById(id);
	}
	
	public List<User> getUser(){
		return User.u.find("select * from Bas_userinfo where Dptid = ?",this.get("DptID"));
	}
	
	public List<Project> getProject(){
		log.debug("this.dptid = "+ this.get("DptID"));
		return Project.p.find("select * from Info_prjvalues where Dptid = ?",this.get("DptID"));
	}
	
	
}
