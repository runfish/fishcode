/**
 * 
 */
package net.dfrz.supershop01.services;

import java.util.List;

import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.utils.Page;

/**                
 * Project: supershop01-02
 * ClassName: DealService                                                        
 * Module ID: 4.6  
 * Comments: ��ҵ���Ϊ����������ṩ����ɾ�����޸ġ����ҵĹ���  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-9
 * @see net.dfrz.supershop01.domain.Deal
 * @see #updateDeal(Deal)
 * @see #deleteDeal(Deal)
 * @see #getDealById(Integer)
 * @Author J1205-HongHG                                                      
 * @version Version 5 
 */
public interface DealService {
	/**
	 * ����������޸�
	 * @param deal -��������
	 */
	void updateDeal(Deal deal);
	/**
	 * ���������ɾ��
	 * @param deal -��������
	 */
	void deleteDeal(Deal deal);
	/**
	 * ���ݶ�����Ż�ȡ��Ӧ�Ķ�����Ϣ
	 */
	Deal getDealById(Integer dealId);
	/**
	 * ������������ķ�ҳ��ʾ
	 * @param pagedDeal   -ҳ�����
	 * @param helper -��Ʒ������ϲ�ѯ������װ�İ�������
	 * @return Page  
	 */
	Page loadPage(Page pagedDeal,DealQuryHelper helper);
	/**
	 * ��ȡ���е���Ʒ������Ϣ
	 * @return List<Deal>
	 */
	List<Deal>loadAll();
}