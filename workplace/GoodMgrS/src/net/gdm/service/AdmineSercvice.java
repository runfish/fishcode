/**
 * 
 */
package net.gdm.service;

import java.util.List;

import javax.xml.registry.infomodel.User;

import net.gdm.demo.Admine;
import net.gdm.util.Page;



/**
 * 管理员记录在XML文件中 用email唯一标识
 *
 */
public interface AdmineSercvice {

	void regAdmine(Admine adm);//超级管理员权限
	Admine getAdmine(String email);
	void modifyInfo(Admine adm);
	void modifyPwd(Admine adm);
	void addAdine(Admine adm);
	void delAdmine(Admine adm);//超级管理员权限
	List<Admine> loadAdmine();
	Page loadPagedAdmine(AdmineQueryHelper helper,Page page);//超级管理员权限
	
}
