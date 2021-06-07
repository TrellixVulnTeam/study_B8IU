package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ArticleNoFoundException;
import article.service.ModifyArticleService;
import article.service.ModifyRequest;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.command.commandHandler;

public class ModifyArticleHandler implements commandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/modifyForm.jsp";
	private ReadArticleService readService = new ReadArticleService();
	private ModifyArticleService modifyService = new ModifyArticleService();
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
	private String processForm(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		try {
			String noVal = req.getParameter("no");
			int no = Integer.parseInt(noVal);
			//req 객체에서 세션을 실행한 후 로그인한 사용자의 아이디 정보 속성을 가져옴(authUser)
			User authUser = (User)req.getSession().getAttribute("authUser");
			//제목, 내용을 모두 포함
			ArticleData articleData = readService.getArticle(no);
			//글수정이 가능한지 체킹 시작///////////////////////////////////////
			if(!canModify(authUser, articleData)) {//로그인id != 글작성id
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			//글수정이 가능한지 체킹 끝///////////////////////////////////////
			
			//회원id, 글번호, 글제목, 글내용을 modReq 객체에 담음
			ModifyRequest modReq = new ModifyRequest(authUser.getId(),
					no,
					articleData.getArticle().getTitle(), 
					articleData.getContent());
			//request 기본 객체에 modReq 객체를 담음
			req.setAttribute("modReq", modReq);
			
			return FORM_VIEW;
		}catch(ArticleNoFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	//POST
	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		//session으로부터 사용자 정보를 가져옴(Object)
		User authUser = (User)req.getSession().getAttribute("authUser");
		//글번호 가져오기(기본키 데이터-unique)
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		//String userId, int articleNumber, String title, String content
		ModifyRequest modReq 
			= new ModifyRequest(authUser.getId()
					, no
					, req.getParameter("title")
					, req.getParameter("content"));
		//request객체의 modReq 속성의 값을 마지막 데이터로 재설정
		req.setAttribute("modReq", modReq);
		//오류 처리
		Map<String,Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		//ModifyRequest 자바빈 클래스의 객체에 title과 content 필드가 있으므로
		//null체크가 용이함
		modReq.validate(errors);
		//문제가 발생하면 modifyForm.jsp로 되돌아감
		if(!errors.isEmpty()) {	
			return FORM_VIEW;
		}
		
		modifyService.modify(modReq);
		return "/WEB-INF/view/modifySuccess.jsp";
	}
	
	private boolean canModify(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getWriterId();	//글작성한 id
		return authUser.getId().equals(writerId);	//로그인한 사용자id.equals(글작성id)
	}
}







