package net.gdm.service;

import java.util.List;

import net.gdm.demo.BigCategory;

public interface BigCategoryService {

	
	void regBigCtg(BigCategory bctg);
    List<BigCategory> loadall();
    BigCategory getCtg(Integer ctgId);
    
    void modifyCtg(BigCategory bctg);
    void delBigCtg(BigCategory bctg);
	
}
