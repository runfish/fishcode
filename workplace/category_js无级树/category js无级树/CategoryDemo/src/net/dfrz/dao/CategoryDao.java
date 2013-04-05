/**
 * 
 */
package net.dfrz.dao;

import java.util.List;

import net.dfrz.domain.Category;

/**
 * @author ctd
 *
 */
public interface CategoryDao {
	
	void add(Category ctg);
	List<Category> getSubCtgs(Integer ctgPid);
	List<Category> loadall();

}
