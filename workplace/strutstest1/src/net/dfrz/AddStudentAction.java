package net.dfrz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AddStudentAction extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	private Integer count = 0;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		String name =mapping.getName();
		String path = mapping.getPath();
		String type = mapping.getType();
		System.out.println("name="+name+"path="+path+"type="+type);
		
		String [] forwardNames= mapping.findForwards();
		for(String forwardName: forwardNames){
			ActionForward actionForward =mapping.findForward(forwardName);
			System.out.println(actionForward.toString());
		}
		
		AddStudentForm addStudentForm = null;
		if(mapping.getScope().equals("request")){
			System.out.println("the scope is request");
			addStudentForm = (AddStudentForm)request.getAttribute("addStudentForm");
		}
		else{
			System.out.println("the scope is session");
			addStudentForm =(AddStudentForm)request.getSession().getAttribute("addStudentForm");
		}
		
		if(addStudentForm==form){
			System.out.println("addStudentFormInScope==form");
		}
		
	
		
		
		
		synchronized (count) {
			count++;
			AddStudentForm studentForm = (AddStudentForm)form;
			DfrzDao dfrzDao = new DfrzDaoImpl();
			boolean success = false;
			success = dfrzDao.addStudent(studentForm);
			
			String returnValue ="addStudentFailure";
			if(success==true)
				returnValue = "addStudentSuccess";
			else if(studentForm.getSname().equals("xiaoyu")){
				returnValue = "error";
			}
		

			return mapping.findForward(returnValue);
			
		}
	
	}

	
}
