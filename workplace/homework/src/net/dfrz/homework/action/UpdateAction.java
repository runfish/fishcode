package net.dfrz.homework.action;

import java.util.Map;

import net.dfrz.homework.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {

	private int userid;

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String execute() {

		return this.NONE;
	}

	public String update() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> requestMap = (Map<String, Object>) actionContext
				.get("request");

		for (User user : User.userList) {

			if (this.userid == user.getUserid()) {

				requestMap.put("user", user);

			}
		}

		return "forupdate";

	}

}
