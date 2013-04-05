package net.dfrz.action;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class OgnlAction extends ActionSupport {

	
	private String name;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {

		ActionContext actionContext = ActionContext.getContext();

		Map<String, Object> applicationMap = (Map<String, Object>) actionContext
				.getApplication();
		Map<String, Object> sessionMap = (Map<String, Object>) actionContext
				.getSession();
		Map<String, Object> requestMap = (Map<String, Object>) actionContext
				.get("request");

		applicationMap.put("app_key", "xiaoyu");
		sessionMap.put("sess_key", "xiaoyuer");
		requestMap.put("req_key", new Date());
		this.name = "xiaoyuero";
		
		ValueStack valueStack = actionContext.getValueStack();
		
		valueStack.set("name","haha");
		
	//	valueStack.setValue("name", "lh");
		
		actionContext.put("xiaoyu", "xiaoyu");

		return this.SUCCESS;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
