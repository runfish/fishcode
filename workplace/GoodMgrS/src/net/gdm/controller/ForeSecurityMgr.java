package net.gdm.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gdm.demo.User;
import net.gdm.exception.ApplicateionException;
import net.gdm.service.UserService;
import net.gdm.service.UserServiceImpl;
import net.gdm.util.SysUtils;

public class ForeSecurityMgr extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");

		if ("tologin".equals(act)) {// 去登入界面  要验证码  js怎么做验证码????????????
			
//			response.sendRedirect(SysUtils.getSrvPath(request)+"jsps/fore/login.jsp");
			
			
			
			
			request.getRequestDispatcher("/jsps/fore/login.jsp").forward(
					request, response);
		} else if ("toreg".equals(act)) {// 去注册界面


			response.sendRedirect(SysUtils.getSrvPath(request)+"jsps/fore/user/reg_user.jsp");
//			request.getRequestDispatcher("/jsps/fore/user/reg_user.jsp")
//					.forward(request, response);
		} else if ("login".equals(act)) {// check用户 /去原页面   
			                            //3.	不管登录成功与否，都记住登录的用户名，下次登录自动输入用户名。

			HttpSession session=request.getSession();
			String preUrl=(String)session.getAttribute("preurl");
			//session.setAttribute("useremail", request.getParameter("useremail"));
			
			
			User user = new User();
			user.setUser_email(request.getParameter("useremail"));
			user.setUser_pwd(request.getParameter("userpwd"));

			UserService userService = new UserServiceImpl();
			try {
				user = userService.checkUser(user);
				request.getSession().setAttribute("loginedUser", user);

				if(preUrl==null){
					preUrl=SysUtils.getSrvPath(request);
				}

				response.sendRedirect(preUrl);
				

			} catch (ApplicateionException e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("jsps/fore/login.jsp").forward(request, response);
				return;
			}

		} else if ("reg".equals(act)) {// 注册成功后自动登陆进入用户中心基本资料页。
			HttpSession session = request.getSession();

			User user = new User();

			user.setUser_name(request.getParameter("username"));
			user.setUser_pwd(request.getParameter("userpwd"));
			user.setUser_real_name(request.getParameter("userrealname"));

			SimpleDateFormat sdf = new SimpleDateFormat();
			try {
				user.setUser_date(sdf.parse(request.getParameter("userdate")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			user.setUser_email(request.getParameter("useremail"));
			user.setUser_phone(request.getParameter("userphone"));
			user.setUser_addr(request.getParameter("useraddr"));
			user.setUser_postcode(request.getParameter("userpostcode"));
			user.setUser_sex(request.getParameter("usersex")); // 要有性别

			UserService userService = new UserServiceImpl();
			try {
				userService.regUser(user);
				session.setAttribute("logineduser", user);
			} catch (Exception e) {
				e.getStackTrace();
			}

			request.getRequestDispatcher("/fusermgr?act=showuser").forward(
					request, response);

		}else if("logout".equals(act)){

			request.getSession().removeAttribute("logineduser");
			request.getSession().removeAttribute("useremail");
			request.getSession().removeAttribute("preurl");
			request.getSession().removeAttribute("shoppingcart");
			request.getSession().invalidate();
			
			response.sendRedirect("fsecurity?act=tologin");
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
