package lh.xiaoyu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse httpservletresponse)
			throws Exception {
		// TODO Auto-generated method stub
		LoginForm loginForm = (LoginForm)form;
		System.out.println(loginForm.getUesrName());
		if(loginForm.getUesrName().equals("xiaoyu"))
			return mapping.findForward("loginSuccess");
		else 
			return mapping.findForward("loginFailure");
		
		
	}
	
	

}
