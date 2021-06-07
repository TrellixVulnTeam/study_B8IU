package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.Article;
import article.model.Writer;
import article.model.list.ArticlePage;
import article.service.ListArticleService;
import article.service.WriteArticleService;
import article.service.WriteRequest;
import auth.service.User;
import mvc.command.CommandHandler;

public class ListArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/listArticle.jsp";

	private ListArticleService listArticleService = ListArticleService.getInstance();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int pageNum = 0;

		try {
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageNum = 1;
		}

		ArticlePage articlePage = listArticleService.getArticlePage(pageNum);
		request.setAttribute("articlePage", articlePage);

		return FORM_VIEW;
	}
}
