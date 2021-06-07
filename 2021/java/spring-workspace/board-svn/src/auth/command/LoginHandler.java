package auth.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.commandHandler;

public class LoginHandler implements commandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/loginForm.jsp";
	private LoginService loginService = new LoginService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")){
			return processSubmit(req, res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	//요청 방식이 GET
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception{
	//폼에서 전송한 id 파라미터와 password 파라미터 값을 구함
	String id = req.getParameter("id");
	String password = req.getParameter("password");
	
	//오류 정보를 담을 맵 객체를 생성하고 errors 속성에 저장
	Map<String, Boolean> errors = new HashMap<>();
	req.setAttribute("errors", errors);
	//id나 password 값이 없을 경우 오류를 추가함
	if(id==null || id.isEmpty()) {
		errors.put("id",Boolean.TRUE);
	}
	if(password==null || password.isEmpty()) {
		errors.put("password",Boolean.TRUE);
	}
	
	//오류가 존재 시 폼 뷰를 리턴
	if(!errors.isEmpty()) {
		return FORM_VIEW;
	}
		
		try {
			//loginService.login()을 이용해서 인증을 수행. 로그인 성공 시 User 객체를 리턴
			User user = loginService.login(id,password);
			//User 객체를 세션의 authUser 속성에 저장
//			HttpSession httpSession = req.getSession();
//			httpSession.setAttribute("authUser", user);
			req.getSession().setAttribute("authUser", user);
			// /index.jsp로 리다이렉트
			res.sendRedirect(req.getContextPath() + "/index.jsp"); // /board
			return null;
		}catch(LoginFailException e) {
		//로그인에 실패해서 LoginFailException이 발생하면 해당 오류를 추가하고, 폼을 위한 뷰를 리턴
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
	
}








