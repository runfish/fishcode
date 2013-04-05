package net.dfrz.homework.action;

import java.util.Map;

import net.dfrz.homework.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.accessibility.internal.resources.accessibility;

public class SelectAction extends ActionSupport {

	@Override
	public String execute() {
		return this.NONE;
	}

	public String select() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> requestMap = (Map<String, Object>) actionContext
				.get("request");
		requestMap.put("userlist", User.userList);
		return "listuser";

	}

}
