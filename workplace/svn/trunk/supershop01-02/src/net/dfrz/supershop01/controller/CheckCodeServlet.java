package net.dfrz.supershop01.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CheckCodeServlet extends HttpServlet {
	/**
	 * ͼƬ�Ŀ��
	 */
	private int height=21;
	/**
	 * ͼƬ�ĸ߶�
	 */
	private int width=57;

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
        /**
         * ����������ݵĸ�ʽΪimage/jpeg
         */
		response.setContentType("image/jpeg");
		
		ServletOutputStream out=response.getOutputStream();
		/**
		 * ����һ��ͼƬ������
		 */
		BufferedImage bImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		/**
		 * �ɻ�ͼ�������ø�ͼƬ������������
		 */
		Graphics graphics=bImage.getGraphics();
		/**
		 * ����ͼƬ�ı�����ɫ���������
		 */
		graphics.setColor(getColor(200,250));
		/**
		 * ����ͼƬ����䷶Χ
		 */
		graphics.fillRect(0, 0, width, height);
		/**
		 * ����ͼƬ���ݵ�������ʽ
		 */
		graphics.setFont(new Font("Times New Roman",Font.PLAIN,18));
		/**
		 * �������200����������
		 */
		Random random=new Random();
		graphics.setColor(getColor(160, 200));
		for(int i=0;i<200;i++){
			int x1=random.nextInt(width);
			int y1=random.nextInt(height);
			int x2=random.nextInt(15);
			int y2=random.nextInt(15);
			graphics.drawLine(x1, y1, x1+x2, y1+y2);
		}
		/**
		 * �������100�����ŵ�
		 */
		graphics.setColor(getColor(120, 240));
		for(int i=0;i<100;i++){
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			graphics.drawOval(x,y,0,0);
		}
		/**
		 * �������4��������ֻ��ߴ�д��ĸ
		 */
		String baseString="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String checkcode=RandomStringUtils.random(4,baseString);
		graphics.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
		graphics.drawString(checkcode,0, 16);
		/**
		 * �ͷ�ͼ��������Դ
		 */
		graphics.dispose();
		
		request.getSession().setAttribute("checkcode", checkcode);
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
		encoder.encode(bImage);
		
		out.flush();
		out.close();
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

		doGet(request, response);
	}
	/**
	 * 
	 * @param fc - ��ɫ����
	 * @param bc - ��ɫ����
	 * @return Color
	 */
	public Color getColor(int fc,int bc){
		Random r=new Random();
		if(fc>255) fc=255;
		if(bc>255) bc=255;
		int red=fc+r.nextInt(bc-fc);//��
		int green=fc+r.nextInt(bc-fc);//��
		int blue=fc+r.nextInt(bc-fc);//��
		return new Color(red,green,blue);
	}
}
