package article.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNoFoundException;
import article.service.ArticleData;
import article.service.ArticleNoFoundException;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;

public class ReadArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/readArticle.jsp";

	private ReadArticleService readArticleService = ReadArticleService.getInstance();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String articleNoString = request.getParameter("articleNo");
		int articleNo = 0;

		try {
			articleNo = Integer.valueOf(articleNoString);

			ArticleData articleData = readArticleService.getArticle(articleNo);
			request.setAttribute("articleData", articleData);
			return FORM_VIEW;
		} catch (ArticleNoFoundException e) {
			request.getServletContext().log("no article", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		} catch (ArticleContentNoFoundException e) {
			request.getServletContext().log("no article", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		return null;
	}
}
