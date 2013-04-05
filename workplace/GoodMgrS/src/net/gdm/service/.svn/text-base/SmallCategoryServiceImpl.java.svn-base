package net.gdm.service;

import java.util.ArrayList;
import java.util.List;

import net.gdm.dao.SmallCategoryDao;
import net.gdm.dao.SmallCategoryDaoImpl;
import net.gdm.demo.SmallCategory;

public class SmallCategoryServiceImpl implements SmallCategoryService {

	SmallCategoryDao smallcategorydao=new SmallCategoryDaoImpl();
	@Override
	public void delBigCtg(SmallCategory sctg) {
		// TODO Auto-generated method stub
		smallcategorydao.deleteSmallCategory(sctg.getS_ctg_id());
	}

	@Override
	public SmallCategory getCtg(Integer ctgId) {
		// TODO Auto-generated method stub
		return smallcategorydao.getOne(ctgId);
	}

	@Override
	public List<SmallCategory> loadall() {
		// TODO Auto-generated method stub
		return smallcategorydao.ListOraderItem();
	}

	@Override
	public void modifyCtg(SmallCategory sctg) {
		// TODO Auto-generated method stub
		smallcategorydao.updateSmallCategory(sctg);
	}

	@Override
	public void regSmallCtg(SmallCategory sctg) {
		// TODO Auto-generated method stub
		smallcategorydao.addSmallCategory(sctg);
	}

	@Override
	public List<SmallCategory> loadallByBId(Integer id) {
		List<SmallCategory> smallCtgList=new ArrayList<SmallCategory>();
		
		SmallCategoryDao scd=new SmallCategoryDaoImpl();
		for(SmallCategory smallCtg:scd.ListOraderItem()){
			if(smallCtg.getBigCategory().getB_ctg_id()==id){
				smallCtgList.add(smallCtg);
			}
		}
		
		return smallCtgList;
	}

	@Override
	public String getAjax(Integer id) {
		String result="<span>商品小类：</span><select name=\"qrysctg\" style=\"width=130px;\"><option value=\"\">==请选择==</option>";
		 List<SmallCategory> smallCtgList=this.loadallByBId(id);
		 for(SmallCategory smallCtg:smallCtgList){
			 result+="<option value=\""+smallCtg.getS_ctg_id()+"\">"+smallCtg.getS_ctg_name()+"</option>";
		 }
		return result+="</select>";
	}

}
