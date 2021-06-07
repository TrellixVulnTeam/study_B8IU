package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.ChangePasswordService;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import mvc.command.commandHandler;

public class ChangePasswordHandler implements commandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/changePwdForm.jsp";
	private ChangePasswordService changePwdSvc = new ChangePasswordService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) 
	 throws Exception{
		//id, name
		User user = (User)req.getSession().getAttribute("authUser");
		
		//errors 맵 생성 : 속성명은 errors
		Map<String, Boolean> errors = new HashMap<>();
		//changePwdForm.jsp => ${errors.curPwd}
		req.setAttribute("errors", errors);	//*******
	
		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		
		if(curPwd == null || curPwd.isEmpty()) {
			//errors 맵에 key(curPwd), value(Boolean.TRUE)
			errors.put("curPwd", Boolean.TRUE);
		}
		
		if(newPwd == null || newPwd.isEmpty()) {
			//errors 맵에 key(newPwd), value(Boolean.TRUE)
			errors.put("newPwd", Boolean.TRUE);
		}
		
		//errors 있으면 FORM_VIEW로 보냄
//		if(errors.size()>0) {
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			//비밀번호 변경 기능 실행
			changePwdSvc.changePassword(user.getId(), curPwd, newPwd);
			//비밀번호 변경 성공 시 changePwdSuccess.jsp 뷰로 리턴
			return "/WEB-INF/view/changePwdSuccess.jsp";
		}catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}catch (InvalidPasswordException e) {
			errors.put("badCurPwd", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
	
}







