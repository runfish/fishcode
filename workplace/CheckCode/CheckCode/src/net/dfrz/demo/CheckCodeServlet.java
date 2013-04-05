package net.dfrz.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckCodeServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, IOException {

		this.doPost(request, response);

	}

	// 生成数字和字母的验证码   

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String act=request.getParameter("act");
		
		if("generate".equals(act)){
			BufferedImage img = new BufferedImage(68, 22,BufferedImage.TYPE_INT_RGB);
	
			// 得到该图片的绘图对象   
	
			Graphics g = img.getGraphics();
	
			Random r = new Random();
	
			Color c = new Color(200, 150, 255);
			g.setColor(c);
	
			//填充整个图片的颜色   
			g.fillRect(0, 0, 68, 22);
			//向图片中输出数字和字母   
			StringBuffer sb = new StringBuffer();
			char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
			int index, len = ch.length;
	
			for (int i = 0; i < 4; i++) {
	
				index = r.nextInt(len);
				//验证码字符的颜色
				g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
				g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));// 输出的字体和大小                    
				g.drawString("" + ch[index], (i * 15) + 3, 18);//写什么数字，在图片的什么位置画  
	
				sb.append(ch[index]);
			}
	
			request.getSession().removeAttribute("piccode");
			request.getSession().setAttribute("piccode", sb.toString());
	
			ImageIO.write(img, "JPG", response.getOutputStream());
		}
		else if("checkCode".equals(act)){
			
			String cc=request.getParameter("cc");
			String picCode=(String)(request.getSession().getAttribute("piccode"));
			
			String result="";
			if(cc.equalsIgnoreCase(picCode))
				result="ok";
			else
				result="fail";
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.write(result);
			out.flush();
			out.close();

			
		}

	}

}
