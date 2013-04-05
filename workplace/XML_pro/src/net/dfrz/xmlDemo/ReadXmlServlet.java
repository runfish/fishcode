package net.dfrz.xmlDemo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXmlServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ReadXmlServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//获取一个xml的解析器
		SAXReader reader = new SAXReader();
		
		//解析器解析xml文件
		
		ServletContext servletContext = this.getServletContext();
		String filePathString = servletContext.getRealPath("/data/userinfo.xml");
		File xmlFile = new File(filePathString);
		
		try {
			Document document = reader.read(xmlFile);
			Element rootElement = document.getRootElement();
			String rootName = rootElement.getName();
			
			//获取子节点
			
		   List<Element> elemList=rootElement.elements("userinfo");
		   
		   for(Element element:elemList){
			   
			   System.out.println(element);
			   
			   String userid = element.attributeValue("id");
			   
			   String username = element.elementText("username");
			   
			   String password = element.elementText("password");
			   
			   String address = element.elementText("address");
			   
			   
			   System.out.println(userid+"\t"+password+"\t"+username+"\t"+address);
		   }
		   
		   
			
			System.out.println(rootName);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
