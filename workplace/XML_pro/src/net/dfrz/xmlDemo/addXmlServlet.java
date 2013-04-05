package net.dfrz.xmlDemo;

import java.io.File;
import java.io.FileWriter;
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
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class addXmlServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addXmlServlet() {
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
		System.out.println(System.getProperty("user.dir"));
		ServletContext servletContext = this.getServletContext();
		String filePathString = servletContext.getRealPath("/data/userinfo.xml");
		File xmlFile = new File(filePathString);
		
		try {
			//添加一个子节点
			Document document = reader.read(xmlFile);
			Element rootElement = document.getRootElement();
	   
			Element userinfo = rootElement.addElement("userinfo");
			userinfo.addAttribute("id", "6");
			
			Element username = userinfo.addElement("username");
			username.addText("saishun");
			
			Element password = userinfo.addElement("password");
			username.addText("password");
			
			Element mail = userinfo.addElement("mail");
			username.addText("mail");
			Element address = userinfo.addElement("address");
		    address.addCDATA("asjkhdkjahdkahl;ha，、amam/");
		    
		    
		    
		    //将document里面的内容重新写进xml文件了
		    OutputFormat outputFormat = new OutputFormat();
		    outputFormat.setEncoding("GBK");
		    outputFormat.setIndent("\t");

		    XMLWriter writer = new XMLWriter(new FileWriter(xmlFile),outputFormat);
		    
		    
		    writer.write(document);
		    writer.flush();
		    writer.close();

			
			
			
	
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
		
	
		

	
	}

}
