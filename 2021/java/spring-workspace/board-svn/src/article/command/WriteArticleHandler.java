package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.Writer;
import article.service.WriteArticleService;
import article.service.WriteRequest;
import auth.service.User;
import mvc.command.commandHandler;

public class WriteArticleHandler implements commandHandler{
	private static final String FORM_VIEW = "/WEB-INF/view/newArticleForm.jsp";
	private WriteArticleService writeService = new WriteArticleService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	//GET
	private String processForm(HttpServletRequest rs, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	//POST
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		//세션에서 로그인한 사용자의 정보를 가져옴
		User user = (User)req.getSession(false).getAttribute("authUser");
				
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		//Writer writer, String title, String content
		WriteRequest writeReq = new WriteRequest(
				new Writer(user.getId(),user.getName()), title, content
				);
		//제목이 입력되어있지 않으면 errors 맵에 put을 함
		if(title==null || title.isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
//		writeReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newArticleNo = writeService.write(writeReq);
		
		req.setAttribute("newArticleNo", newArticleNo);
		
		return "/WEB-INF/view/newArticleSuccess.jsp";
	}

}



