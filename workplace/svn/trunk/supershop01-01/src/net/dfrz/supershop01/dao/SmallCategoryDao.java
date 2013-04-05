/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.ArrayList;
import java.util.List;

import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.utils.Page;



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
    List<SmallCategory>loadPage(int beginIndex, int endIndex);
    int countSmallCategory();
}
