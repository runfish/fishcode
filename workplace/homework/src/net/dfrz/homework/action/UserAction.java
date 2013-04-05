package net.dfrz.homework.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.dfrz.homework.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> requestMap = (Map<String, Object>) actionContext
			.get("request");

	private User user;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() {

		return null;
	}

	public String save() {

		if (User.userList.size() > 0) {
			int index = 0;
			for (User user : User.userList) {
				index++;
				if (this.user.getUserid() == user.getUserid()) {
					User.userList.remove(index - 1);
					break;
				}
			}
			User.userList.add(this.user);
			requestMap.put("user", this.user);
		}

		if (User.userList.size() == 0) {
			User.userList.add(this.user);
			requestMap.put("user", this.user);
		}

		return "userinfo";

	}
}