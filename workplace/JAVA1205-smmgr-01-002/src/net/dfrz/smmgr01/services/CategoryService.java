package net.dfrz.smmgr01.services;

import java.util.List;

import net.dfrz.smmgr01.domain.Category;
import net.dfrz.smmgr01.utils.Page;

public interface CategoryService {

	void addCtg(Category ctg);
	void deleteCtg(Category ctg);
	Category getCategoryById(int ctgId);
	void updateCtg(Category ctg);
	List<Category> loadAll();
	Page loadPageAll(Page page);
}
