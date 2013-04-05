/**
 * 
 */
package net.gdm.service;

import java.util.List;

import net.gdm.dao.AdmineDao;
import net.gdm.dao.AdmineDaoImpl;
import net.gdm.demo.Admine;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public class AdmineSercviceImpl implements AdmineSercvice {
     AdmineDao adminedao=new AdmineDaoImpl();
	@Override
	public void delAdmine(Admine adm) {
		// TODO Auto-generated method stub
		adminedao.deleteAdmine(adm.getAdimine_id());
	}

	@Override
	public Admine getAdmine(String email) {
		// TODO Auto-generated method stub
		return adminedao.getOne(email);
	}

	@Override
	public Page loadPagedAdmine(AdmineQueryHelper helper, Page page) {
		// TODO Auto-generated method stub
		return adminedao.loadPagedAdmine(helper, page);
	}

	@Override
	public void modifyInfo(Admine adm) {
		// TODO Auto-generated method stub
		adminedao.updateAdmine(adm);
	}

	@Override
	public void modifyPwd(Admine adm) {
		// TODO Auto-generated method stub
		adminedao.modifyPwd(adm);
	}

	@Override
	public void regAdmine(Admine adm) {
		// TODO Auto-generated method stub
		adminedao.addAdmine(adm);
	}

	@Override
	public void addAdine(Admine adm) {
		// TODO Auto-generated method stub
		adminedao.addAdmine(adm);
	}

	@Override
	public List<Admine> loadAdmine() {
		// TODO Auto-generated method stub
		return adminedao.ListAdmine();
	}

}
