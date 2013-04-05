package net.gdm.service;

import java.util.List;

import net.gdm.dao.BigCategoryDao;
import net.gdm.dao.BigCategoryDaoImpl;
import net.gdm.demo.BigCategory;

public class BigCategoryServiceImpl implements BigCategoryService {
   
	BigCategoryDao bigcategorydao=new BigCategoryDaoImpl();
	
	@Override
	public void delBigCtg(BigCategory bctg) {
		// TODO Auto-generated method stub
		bigcategorydao.deleteBig(bctg.getB_ctg_id());
	}

	@Override
	public BigCategory getCtg(Integer ctgId) {
		// TODO Auto-generated method stub
		return bigcategorydao.getOne(ctgId);
	}

	@Override
	public List<BigCategory> loadall() {
		// TODO Auto-generated method stub
		return bigcategorydao.listbig();
	}

	@Override
	public void modifyCtg(BigCategory bctg) {
		// TODO Auto-generated method stub
		bigcategorydao.updateBig(bctg);
	}

	@Override
	public void regBigCtg(BigCategory bctg) {
		// TODO Auto-generated method stub
		bigcategorydao.addBig(bctg);
	}

}
