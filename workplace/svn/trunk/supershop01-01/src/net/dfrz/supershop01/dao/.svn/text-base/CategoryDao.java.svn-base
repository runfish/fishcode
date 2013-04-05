/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;

import net.dfrz.supershop01.domain.Category;

/**
 * @author YouHQ
 *
 */
public interface CategoryDao {

	void add(Category ctg);
	void delete(int ctgId);
	Category getCtgById(int ctgId);
	void update(Category ctg);
	List<Category> loadAll();
	List<Category>loadPageAll(int beginIndex,int endIndex);
	int countCategory();
	List<Category> getSubCtgs(Integer ctgPid);
}
