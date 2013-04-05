package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dfrz.supershop01.domain.Administrator;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.services.DealItemService;
import net.dfrz.supershop01.services.DealService;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.CategoryServiceImpl;
import net.dfrz.supershop01.servicesimpl.DealItemServiceImpl;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.servicesimpl.DealServiceImpl;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;
import net.dfrz.supershop01.utils.Page;
/**
 * 
 * @author J1205-HongHG
 *
 */
public class DealItemServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DealItemServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String act=request.getParameter("act");
		
		if("loadPageDealItem".equals(act))
		{
			Integer dealId=Integer.parseInt(request.getParameter("dealid"));
			request.getSession(false).setAttribute("dealId", dealId);
			DealItemService dealItemService=new DealItemServiceImpl();
			DealService dealService=new DealServiceImpl();
			GoodsService goodsService=new GoodsServiceImpl();
			SmallCategoryService smallCategoryService=new SmallCategoryServiceImpl();
			Integer pageNo=null;
			
			Page pagedDealItem=new Page();
			pagedDealItem.setPageSize(50);
			try 
			{
				pagedDealItem=dealItemService.loadPage(pagedDealItem, dealId);
				List<DealItem>dealItemList=(List<DealItem>)pagedDealItem.getPageContent();
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				Deal deal=dealService.getDealById(dealId);
				out.print("<div style=\"border:1px solid gray;background:#eae7d7\">");
				out.print("订单基本信息");
				out.print("</div>");
				out.print("<div>");
				out.print("收货人名:"+deal.getConsigneeInfo().split(":")[0]);
				out.print("</div>");
				out.print("<div>");
				out.print("收货地址："+deal.getConsigneeInfo().split(":")[1]);
				out.print("</div>");
				out.print("<div>");
				out.print("邮政编码："+deal.getConsigneeInfo().split(":")[2]);
				out.print("</div>");
				out.print("<div>");
				out.print("联系方式："+deal.getConsigneeInfo().split(":")[3]);
				out.print("</div>");
				out.print("<div>");
				out.print("电子邮箱："+deal.getConsigneeInfo().split(":")[4]);
				out.print("</div>");
				out.print("<hr>");
				if(deal.getPayPattern().equals("b"))
				{
					out.print("<div>");
					out.print("付款方式：货到付款");
					out.print("</div>");
				}
				else if(deal.getPayPattern().equals("c"))
				{
					out.print("<div>");
					out.print("付款方式：网银支付");
					out.print("</div>");
				}
				if(deal.getReceivePattern().equals("b"))
				{
					out.print("<div>");
					out.print("收货方式：平邮");
					out.print("</div>");
				}
				if(deal.getReceivePattern().equals("c"))
				{
					out.print("<div>");
					out.print("收货方式：快递");
					out.print("</div>");
				}
				if(deal.getReceivePattern().equals("d"))
				{
					out.print("<div>");
					out.print("收货方式：ESM");
					out.print("</div>");
				}
				out.print("<hr>");
				out.print("<div>");
				out.print("下单时间："+deal.getDealDate());
				out.print("</div>");
				if(deal.getDealStatus().equals("a"))
				{
					out.print("<div>");
					out.print("订单状态：未审核");
					out.print("</div>");
				}
				if(deal.getDealStatus().equals("b"))
				{
					out.print("<div>");
					out.print("订单状态：已审核");
					out.print("</div>");
				}
				if(deal.getDealStatus().equals("c"))
				{
					out.print("<div>");
					out.print("订单状态：审核未通过");
					out.print("</div>");
				}
				if(deal.getDealExamDate()!=null)
				{
					out.print("<div>");
					out.print("审核时间："+deal.getDealExamDate());
					out.print("</div>");
				}
				else
				{
					out.print("<div>");
					out.print("审核时间：------");
					out.print("</div>");
				}
				out.print("<div style=\"border:1px solid gray;background:#eae7d7\">");
				out.print("订单条目信息");
				out.print("</div>");
				out.print("<div>");
				out.println("<table id=\"listtable\" cellpadding=\"0\" cellspacing=\"0\">");
				out.println("<tr>");
				out.print("<th>");
				out.print("条目编号");
				out.print("</th>");
				out.print("<th>");
				out.print("商品名称");
				out.print("</th>");
				out.print("<th>");
				out.print("商品类型");
				out.print("</th>");
				out.print("<th>");
				out.print("商品单价");
				out.print("</th>");
				out.print("<th>");
				out.print("商品数量");
				out.print("</th>");
				out.print("<th>");
				out.print("商品总额");
				out.print("</th>");
				out.print("<th>");
				out.print("操作");
				out.print("</th>");
				out.println("</tr>");
				for(DealItem item:dealItemList)
				{
					out.println("<tr onmouseover=\"onMouseOver(this);\" onmouseout=\"noMouseOut(this);\">");
					out.print("<td>");
					out.print(item.getItemId());
					out.print("</td>");
					out.print("<td>");
					Goods goods=goodsService.getGoodsById(item.getDealGoodsId());
					out.print(goods.getGoodsName());
					out.print("</td>");
					out.print("<td>");
					SmallCategory smallCategory=smallCategoryService.getCtg(item.getDealGoodsCtgId());
					Category category=smallCategory.getBigCategory();
					out.print(category.getCtgName()+"->"+smallCategory.getSmallCtgName());
					out.print("</td>");
					out.print("<td>");
					out.print(item.getItemGoodsPrice());
					out.print("</td>");
					out.print("<td>");
					out.print(item.getItemGoodsQty());
					out.print("</td>");
					out.print("<td>");
					out.print(item.getItemGoodsPrice()*item.getItemGoodsQty());
					out.print("</td>");
					out.print("<td>");
					out.print("<button onclick=\"javascript:removeDeal("+dealId+",'dealItem',"+item.getItemId()+");\" style=\"cursor:hand\">删除</button>");
					out.print("</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.print("</div>");
				
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(act.equals("del"))
		{
			response.setCharacterEncoding("utf-8");
			Integer itemId=Integer.parseInt(request.getParameter("itemid"));
			DealItemService dealItemService=new DealItemServiceImpl();
			DealItem dealItem=dealItemService.getDealItemById(itemId);
			try 
			{
				dealItemService.deleteDealItem(dealItem);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				PrintWriter out=response.getWriter();
				out.println("订单条目编号:"+itemId+"的信息删除失败！");
				out.flush();
				out.close();
			}
			
			PrintWriter out=response.getWriter();
			out.println("订单条目编号:"+itemId+"的信息已经成功删除！");
			out.flush();
			out.close();
		}
	}
	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
