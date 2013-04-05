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
import net.gdm.service.UserService;
import net.gdm.service.UserServiceImpl;

public class ForeUserMgr extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act").trim();

		if ("showuser".equals(act)) {// （先验证session范围是否有用户 filter 验证）去

			request.getRequestDispatcher("/jsps/fore/user/show_user.jsp")
					.forward(request, response);

		} else if ("formodyfiuser".equals(act)) {// 去 更改用户信息 页面

			request.getRequestDispatcher("/jsps/fore/user/modify_user.jsp")
					.forward(request, response);

		} else if ("modyfiuser".equals(act)) {// 更改用户信息 /先更改session中的用户信息，在存盘
			HttpSession session = request.getSession();

			User user = (User) session.getAttribute("logineduser");

			user.setUser_addr(request.getParameter("useraddr"));

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			try {
				user.setUser_date(sdf.parse(request.getParameter("userdate")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			user.setUser_email(request.getParameter("useremail"));
			user.setUser_phone(request.getParameter("userphone"));
			user.setUser_postcode(request.getParameter("userpostcode"));
			user.setUser_real_name(request.getParameter("userrealname"));
			user.setUser_sex(request.getParameter("usersex"));

			UserService userService = new UserServiceImpl();
			userService.modifyInfo(user);
			
			
			request.getRequestDispatcher("/jsps/fore/user/modify_success.jsp")
			.forward(request, response);

		} else if ("formodyfipwd".equals(act)) {// 去 更改密码 页面

			request.getRequestDispatcher("/jsps/fore/user/modify_pwd.jsp")
					.forward(request, response);

		} else if ("modyfipwd".equals(act)) {// 更改密码 /先更改session中的用户信息，在存盘
			HttpSession session = request.getSession();

			User user = (User) session.getAttribute("logineduser");

			user.setUser_pwd(request.getParameter("newpwd"));
			
			UserService userService = new UserServiceImpl();
			userService.modifyPwd(user);
			
			request.getRequestDispatcher("/jsps/fore/user/modify_success.jsp")
			.forward(request, response);
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
