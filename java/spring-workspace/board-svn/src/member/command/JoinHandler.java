package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.commandHandler;

public class JoinHandler implements commandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";
	private JoinService joinService = new JoinService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//요청 방식이 GET이면
		if(req.getMethod().equalsIgnoreCase("GET")) {
			 return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {	//요청 방식이 POST
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
	//요청 방식이 POST
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		JoinRequest joinReq = new JoinRequest();
		joinReq.setId(req.getParameter("id"));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		
		//오류 정보를 담을 Map 객체를 생성
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		joinReq.validate(errors);
		//데이터가 비거나 비밀번호 일치하지 않으면 joinForm.jsp로 돌려보냄
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		//성공 시
		try {
			joinService.join(joinReq);
			return "/WEB-INF/view/joinSuccess.jsp"; 
		}catch(DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
		
		
		
	}
	
}







