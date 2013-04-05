package net.dfrz.supershop01.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import net.dfrz.supershop01.dao.CategoryDao;
import net.dfrz.supershop01.dao.DaoFactory;
import net.dfrz.supershop01.dao.SmallCategoryDao;
import net.dfrz.supershop01.daoimpl.SmallCategoryDaoJDBCImpl;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;
import net.dfrz.supershop01.utils.TransactionManager;


public class SmallCategoryServiceImpl implements SmallCategoryService {
	
	SmallCategoryDao smallcategorydao=new SmallCategoryDaoJDBCImpl();

	
	
	public void delBigCtg(SmallCategory sctg) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();
		try{
			manager.beginTransaction();
		    smallcategorydao.deleteSmallCategory(sctg.getSmallCtgId());
		}catch(Exception e){
			e.printStackTrace();
		    manager.rollbackAndClose();	
		    throw new ApplicationException(e.getMessage());
		}
	}

	
	
	public SmallCategory getCtg(Integer ctgId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();
		SmallCategory smallCategory = null;
		try{
			manager.beginTransaction();
			smallCategory = smallcategorydao.getOne(ctgId);
		}catch(Exception e){
			e.printStackTrace();
		    manager.rollbackAndClose();
		    throw new ApplicationException(e.getMessage());
		}
	
		return smallCategory;
	
	}

	
	
	public List<SmallCategory> loadall() {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();
		List<SmallCategory>  smallList = null ;
		try{
			
			manager.beginTransaction();
			smallList = smallcategorydao.ListOraderItem();
	
		}catch(Exception e){
			e.printStackTrace();
		    manager.rollbackAndClose();	
		    throw new ApplicationException(e.getMessage());
		}
		return smallList;
	}

	
	
	public void modifyCtg(SmallCategory sctg) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();
		SmallCategoryDao smallCtgDao=(SmallCategoryDao)DaoFactory.getDao("SmallCategoryDao");
		try 
		{
			manager.beginTransaction();
			smallCtgDao.updateSmallCategory(sctg);
			manager.commitAndClose();
			
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}

	public void addSmallCtg(SmallCategory sctg) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();
		try{
			manager.beginTransaction();
		    smallcategorydao.addSmallCategory(sctg);
		}catch(Exception e){
			e.printStackTrace();
		  manager.rollbackAndClose();
		  throw new ApplicationException(e.getMessage());
		}
	}

	public List<SmallCategory> loadallByBId(Integer id) {
		TransactionManager manager = DBUtils.getTranManager();
		List<SmallCategory> smallCtgList = null;
		try{
			manager.beginTransaction();
			smallCtgList=new ArrayList<SmallCategory>();
		
		    SmallCategoryDao scd=new SmallCategoryDaoJDBCImpl();
		    for(SmallCategory smallCtg:scd.ListOraderItem()){
			    if(smallCtg.getBigCategory().getCtgId()==id){
				    smallCtgList.add(smallCtg);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		    manager.rollbackAndClose();	
		    throw new ApplicationException(e.getMessage());
		}
		
		return smallCtgList;
	}

	public String getAjax(Integer id) {
		TransactionManager manager = DBUtils.getTranManager();
		String result = null;
		try{
			manager.beginTransaction();
	        result="<span>商品小类:</span><select name=\"qrysctg\" style=\"width=130px;\"><option value=\"\">==璇烽?夋嫨==</option>";
		    List<SmallCategory> smallCtgList=this.loadallByBId(id);
		    for(SmallCategory smallCtg:smallCtgList){
			    result+="<option value=\""+smallCtg.getSmallCtgId()+"\">"+smallCtg.getSmallCtgName()+"</option>";
		   }
		}catch(Exception e){
			e.printStackTrace();
		    manager.rollbackAndClose();	
		    throw new ApplicationException(e.getMessage());
		}
		return result+="</select>";
	}

	public Page loadPage(Page page) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();
		try{
				manager.beginTransaction();
			    SmallCategoryDao smallCategoryDao=new SmallCategoryDaoJDBCImpl();
			    page.setTotalRecNum((long)smallCategoryDao.countSmallCategory());
			    page.setPageContent(smallCategoryDao.loadPage(page.getStartIndex(), page.getEndIndex()));
		}catch(Exception e){
			e.printStackTrace();
		    manager.rollbackAndClose();	
		    throw new ApplicationException(e.getMessage());
		}
		return page;
	}



	public void deleteSmallCtg(int id) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try 
		{
			manager.beginTransaction();
			SmallCategoryDao smallCtgDao=(SmallCategoryDao)DaoFactory.getDao("SmallCategoryDao");
			smallCtgDao.deleteSmallCategory(id);
			manager.commitAndClose();
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}
	

}
