package net.gdm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gdm.demo.SmallCategory;
import net.gdm.service.BigCategoryService;
import net.gdm.service.BigCategoryServiceImpl;
import net.gdm.service.GoodsQueryHelper;
import net.gdm.service.GoodsService;
import net.gdm.service.GoodsServiceImpl;
import net.gdm.service.SmallCategoryService;
import net.gdm.service.SmallCategoryServiceImpl;
import net.gdm.util.Page;

public class ForeGoodsMgr extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act=request.getParameter("act").trim();
		
		if("main".equals(act)){// 分页
			
			GoodsQueryHelper helper=new GoodsQueryHelper();
// Integer bCtg=Integer.parseInt(request.getParameter("qrybctg"));
// Integer sCtg=Integer.parseInt(request.getParameter("qrysctg"));
// String goodsName=request.getParameter("qrygoodsname");
			
			if(request.getParameter("qrybctg")!=null && request.getParameter("qrybctg").trim().length()>0){
				helper.setBCtg(Integer.parseInt(request.getParameter("qrybctg")));
			}
			if(request.getParameter("qrysctg")!=null && request.getParameter("qrysctg").trim().length()>0){
				helper.setSCtg(Integer.parseInt(request.getParameter("qrysctg")));
			}
			if(request.getParameter("qrygoodsname")!=null && request.getParameter("qrygoodsname").trim().length()>0){
				helper.setGoodsName(request.getParameter("qrygoodsname").trim());
			}
			
			Page page=new Page();
			if(helper.getBCtg()==null && helper.getSCtg()==null && helper.getGoodsName()==null){
				page.setPageSize(100000);
			}
			
			String pageNo=request.getParameter("pageno");
			if(pageNo!=null){
				page.setPageNo(Integer.parseInt(pageNo));
			}
			

			GoodsService goodsService=new  GoodsServiceImpl();
			page=goodsService.loadPagedGoods(helper, page);
			request.setAttribute("page",page);
			
			BigCategoryService bcs=new BigCategoryServiceImpl();
			request.setAttribute("biglist", bcs.loadall());
			
			SmallCategoryService scs=new SmallCategoryServiceImpl();
			request.setAttribute("smalllist", scs.loadall());
			
			
			request.getRequestDispatcher("/jsps/fore/main.jsp").forward(request,response);
			
			
		}else if("showgoods".equals(act)){// 详细商品页面
			int goodsId=Integer.parseInt(request.getParameter("goodsid"));
			GoodsService goodsService = new GoodsServiceImpl();
			request.setAttribute("goods",goodsService.getGoods(goodsId));
			
			request.getRequestDispatcher("/jsps/fore/goods/show_goods.jsp").forward(request, response);
			
		}else if("showgoodspic".equals(act)){
			/**
			 * <IMG style="width:90px;height:90px;" alt=${book.bookName}
			 * onclick="showbook('${book.bookCode}');"src="<c:url
			 * value="/workflow?act=showbookcover&bookcode=${book.bookCode}"
			 * />">
			 */
			Integer goodsId=Integer.parseInt(request.getParameter("goodsid"));
			
			GoodsService goodsService=new GoodsServiceImpl();
			byte[] goodsPic=goodsService.loadPic(goodsId);
			
			if(goodsPic==null || goodsPic.length==0){
				String fileName=request.getRealPath("/")+"pic/no_book_cover.jpg";
				File file=new File(fileName);
				FileInputStream fis=new FileInputStream(file);
				goodsPic=new byte[fis.available()];
			
				fis.read(goodsPic);
			}
			
			response.setContentType("image/jpeg");
			ServletOutputStream sos=response.getOutputStream();
			sos.write(goodsPic);
			sos.flush();
			sos.close();
			
		}else if("smallajax".equals(act)){
			Integer qryBctg=null;
			
			if(request.getParameter("qrybctg")!=null && request.getParameter("qrybctg").trim().length()>0){
				qryBctg=(Integer.parseInt(request.getParameter("qrybctg")));
			}
			
			SmallCategoryService scs= new SmallCategoryServiceImpl();
			String result=scs.getAjax(qryBctg);
			PrintWriter out=response.getWriter();
			out.print(result);
		    
			out.flush();
			out.close();
			
		}
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
