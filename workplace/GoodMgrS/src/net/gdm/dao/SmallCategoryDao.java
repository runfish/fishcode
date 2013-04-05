/**
 * 
 */
package net.gdm.dao;

import java.util.List;

import net.gdm.demo.SmallCategory;

/**
 * @author Administrator
 *
 */
public interface SmallCategoryDao {
	List<SmallCategory> ListOraderItem();
    void addSmallCategory(SmallCategory samllcategory);
    void updateSmallCategory(SmallCategory samllcategory);
    SmallCategory getOne(int id);
    void deleteSmallCategory(int id);
}
