/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
/**                
 * Project: supershop01-01
 * ClassName: DealDao                                                        
 * Module ID: 4.6  
 * Comments: 在数据层为订单类对象提供数据删除，修改、查找的功能  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-8
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Deal
 * @see #add(Deal)
 * @see #update(Deal)
 * @see #delete(Deal)
 * @see #getDealById(Integer)
 * @Author J1205-HongHG                                                      
 * @version Version 117      
 */
public interface DealDao {

	/**
	 * 增加订单对象
	 * @param deal -订单对象
	 */
	void add(Deal deal);
	/**
	 * 订单对象的修改
	 * @param deal -订单对象
	 */
	void update(Deal deal);
	/**
	 * 订单对象的删除
	 * @param deal -订单对象
	 * @exception net.dfrz.supershop01.exception.DataAccessException 当订单对象不存在时抛出异常
	 */
	void delete(Deal deal);
	/**
	 * 根据订单对象的编号获取对应的订单对象
	 * @param dealId -查找的订单的编号
	 * @exception net.dfrz.supershop01.exception.DataAccessException 当订单对象不存在时抛出异常
	 * @return deal
	 */
	Deal getDealById(Integer dealId);
	/**
	 * 批量订单对象的分页显示
	 * @param startIndex   -页面开始的记录起始位置
	 * @param endIndex   -页面结束的最后一条记录的位置
	 * @param helper -商品订单组合查询条件封装的帮助对象
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return List<DealItem>  
	 */
	List<Deal> loadPage(int startIndex,int endIndex,DealQuryHelper helper);
	/**
	 * 统计数据库集中订单的总数
	 * @param helper -商品订单组合查询条件封装的帮助对象
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return int
	 */
	int countDeal(DealQuryHelper helper);
	/**
	 * 获取全部的商品订单
	 * @return List<Deal>
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 */
	List<Deal>loadAll();
}
