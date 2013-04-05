/**
 * 
 */
package net.gdm.dao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import net.gdm.demo.*;
/**
 * @author Administrator
 *
 */
public class ORACLTEST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         AdmineDao admindao=new AdmineDaoImpl();
    	 DateFormat d = new SimpleDateFormat("yyyy-MM-dd"); 
//         Admine admine=new Admine();
//         admine.setAdimine_id(1);
//         admine.setAdmine_address("厦门大学");
//         try {
//			admine.setAdmine_birth((d.parse("2002-02-03")));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		admine.setAdmine_email("fuzhoudaxue");
//		admine.setAdmine_name("张天明");
//		admine.setAdmine_postcode("123456");
//		admine.setAdmine_pwd("ss456");
//		admine.setAdmine_real_name("张天明");
//		admine.setAdmine_sex("F");
//		admine.setAdmine_tel("12345678910");
//    	 UserDao userdao=new UserDaoImpl();
		OrderDao orderdao=new OrderDaoImpl();
//		Order order=new Order();
//		order.setItems(null);
//		order.setOrder_account(1000);
//		order.setOrder_id(1);
//		try {
//			order.setOrder_time(d.parse("2002-02-03"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        order.setPay_mode("S");
//        order.setReceive_mode("F");
//        order.setReceiver_add("aa");
//        order.setReceiver_email("aaaa");
//        order.setReceiver_name("李四");
//        order.setReceiver_phone("1111111111");
//        order.setReceiver_postcode("123");
//        order.setReceiver_status("S");
//        order.setUser(userdao.getOne(1));
       // List<Order> orderlist=orderdao.ListOrder();
//        Order order=orderdao.getOne(1);
//        order.setReceiver_status("F");
//   	     orderdao.Statusover(order);
//    	 User user=new User();
//    	 user.setUser_addr("sss");
//    	 try {
//			user.setUser_date(d.parse("2002-02-04"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	 user.setUser_email("ssss");
//    	 user.setUser_id(1);
//    	 user.setUser_name("王天福");
//    	 user.setUser_phone("11111");
//    	 user.setUser_postcode("sss");
//    	 user.setUser_pwd("1234");
//    	 user.setUser_real_name("ss\\\\");
//    	 user.setUser_sex("S");
//    	 user.setUser_status("S");
//    	 userdao.addUser(user);
//         OrderItemDao orderitemdao=new OrderItemDaoImpl();
//    	 
		GoodsDao goodsdao=new GoodsDaoImpl();
    	 OrderItem orderitem=new OrderItem();
    	 orderitem.setItem_amount(1);
    	 orderitem.setItem_goods_price(120.3);
    	 orderitem.setItem_id(1);
    	 orderitem.setOrder(orderdao.getOne(1));
    	 orderitem.setGoods(goodsdao.getOne(1));
    	 orderitem.setOrder(orderdao.getOne(1));
//		SmallCategoryDao scdao=new SmallCategoryDaoImpl();

//		Goods goods=new Goods();
//		goods.setGoods_desc("F");
//		goods.setGoods_id(1);
//		goods.setGoods_name("abc");
//		goods.setGoods_pic(null);
//		goods.setGoods_price(13.3);
//		goods.setGoods_status("S");
//		goods.setGoods_store("s");
//		goods.setSmallCategory(scdao.getOne(1));
//		goodsdao.UpdateGoods(goods);

		
		
		
		
		//		BigCategoryDao bcd=new BigCategoryDaoImpl();
//		SmallCategoryDao scdao=new SmallCategoryDaoImpl();
//		SmallCategory sc=new SmallCategory();
//		sc.setBigCategory(bcd.getOne(1));
//		sc.setGoodsList(null);
//		sc.setS_ctg_id(1);
//		sc.setS_ctg_name("aa");
//		sc.setS_ctg_status("s");
//		scdao.addSmallCategory(sc);
		
		
		
		
		
		
		
		
	}

}
