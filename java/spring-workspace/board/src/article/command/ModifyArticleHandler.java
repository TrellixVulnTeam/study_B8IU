package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNoFoundException;
import article.service.ArticleData;
import article.service.ArticleNoFoundException;
import article.service.ModifyRequest;
import article.service.ModifyService;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.command.CommandHandler;

public class ModifyArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/modifyForm.jsp";
	private ReadArticleService readArticleService = ReadArticleService.getInstance();
	private ModifyService modifyService = ModifyService.getInstance();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestMethod = request.getMethod();

		if (requestMethod.equalsIgnoreCase("GET")) {
			return processForm(request, response);
		} else if (requestMethod.equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		}
		return null;
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			User authUser = (User) request.getSession().getAttribute("authUser");

			String articleNoValue = request.getParameter("articleNo");
			int articleNo = Integer.valueOf(articleNoValue);

			ArticleData articleData = readArticleService.getArticle(articleNo);
			if (canModify(authUser, articleData)) {
				ModifyRequest modifyRequest = new ModifyRequest(articleData.getArticle().getWriter().getWriterId(), articleData.getArticle().getArticleNo(), articleData.getArticle().getTitle(), articleData.getArticleContent().getContent());
				request.setAttribute("modifyRequest", modifyRequest);
				return FORM_VIEW;
			}
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		} catch (ArticleNoFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		return null;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User authUser = (User) request.getSession().getAttribute("authUser");

		String articleNoValue = request.getParameter("articleNo");
		int articleNo = Integer.parseInt(articleNoValue);
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		ModifyRequest modifyRequest = new ModifyRequest(authUser.getMemberid(), articleNo, title, content);

		request.setAttribute("modifyRequest", modifyRequest);
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		modifyRequest.validate(errors);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		if (0 < modifyService.modify(modifyRequest)) {
			return "/WEB-INF/view/modifySuccess.jsp";
		}

		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return null;
	}

	private boolean canModify(User authUser, ArticleData articleData) {
		return authUser != null && authUser.getMemberid() != null && authUser.getMemberid().equals(articleData.getArticle().getWriter().getWriterId());
	}
}
