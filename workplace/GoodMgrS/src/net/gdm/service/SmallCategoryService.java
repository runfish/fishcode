package net.gdm.service;

import java.util.List;

import net.gdm.demo.SmallCategory;

public interface SmallCategoryService {

	
	void regSmallCtg(SmallCategory sctg);
	
	List<SmallCategory> loadallByBId(Integer bId);
	
    List<SmallCategory> loadall();
    SmallCategory getCtg(Integer ctgId);
    
    void modifyCtg(SmallCategory sctg);
    void delBigCtg(SmallCategory sctg);
    
    
    String getAjax(Integer id);
    
    
}
