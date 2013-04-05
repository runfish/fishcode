/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;

import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
/**                
 * Project: supershop01-01
 * ClassName: DealItemDao                                                        
 * Module ID: 4.6  
 * Comments: �����ݲ�Ϊ������Ŀ������ṩ����ɾ�����޸ġ���ҳ��ʾ�Ĺ���  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-8
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.DealItem
 * @see net.dfrz.supershop01.servicesimpl.DealQuryHelper
 * @see net.dfrz.supershop01.utils.Page
 * @see #update(DealItem)
 * @see #delete(DealItem)
 * @see #getDealItemById(Integer)
 * @see #loadPage(int,int,DealQuryHelper)
 * @see #countDealItem(DealQuryHelper)
 * @see #loadAll()
 * @Author J1205-HongHG                                                      
 * @version Version 5      
 */
public interface DealItemDao {

	/**
	 * ������Ŀ������޸�
	 * @param dealItem -��������
	 */
	void update(DealItem dealItem);
	/**
	 * ������Ŀ�����ɾ��
	 * @param dealItem -��������
	 * @exception net.dfrz.supershop01.exception.DataAccessException ���������󲻴���ʱ�׳��쳣
	 */
	void delete(DealItem dealItem);
	/**
	 * ���ݶ�����Ŀ����ı�Ż�ȡ��Ӧ�Ķ�����Ŀ����
	 * @param itemId -���ҵĶ�����Ŀ�ı��
	 * @exception net.dfrz.supershop01.exception.DataAccessException ���������󲻴���ʱ�׳��쳣
	 * @return DealItem
	 */
	DealItem getDealItemById(Integer itemId);
	/**
	 * ������������ķ�ҳ��ʾ
	 * @param startIndex   -ҳ�濪ʼ�ļ�¼��ʼλ��
	 * @param endIndex   -ҳ����������һ����¼��λ��
	 * @param helper -��Ʒ������ϲ�ѯ������װ�İ�������
	 * @exception net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @return List<DealItem>  
	 */
	List<DealItem> loadPage(int startIndex,int endIndex,int dealId);
	/**
	 * ͳ�����ݿ⼯�ж���������
	 * @param helper -��Ʒ������ϲ�ѯ������װ�İ�������
	 * @exception net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @return int
	 */
	int countDealItem(int dealId);
}
