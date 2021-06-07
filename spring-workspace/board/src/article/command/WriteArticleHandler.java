package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.Writer;
import article.service.WriteArticleService;
import article.service.WriteRequest;
import auth.service.User;
import mvc.command.CommandHandler;

public class WriteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/writeArticle.jsp";

	private WriteArticleService writeArticleService = WriteArticleService.getInstance();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		}
		return null;
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("authUser");

		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		request.setAttribute("errors", errors);

		String title = request.getParameter("title");
		String content = request.getParameter("content");

		WriteRequest writeRequest = new WriteRequest(new Writer(user.getMemberid(), user.getName()), title, content);
		writeRequest.validate(errors);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		int articleNo = writeArticleService.write(writeRequest);

		request.setAttribute("articleNo", articleNo);

		return "/WEB-INF/view/writeArticleSucess.jsp";
	}
}
