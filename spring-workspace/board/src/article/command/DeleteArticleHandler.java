package article.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.DeleteRequest;
import article.service.DeleteService;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler {
	private ReadArticleService readArticleService = ReadArticleService.getInstance();
	private DeleteService deleteService = DeleteService.getInstance();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String articleNoValue = request.getParameter("articleNo");
		int articleNo = Integer.valueOf(articleNoValue);

		User authUser = (User) request.getSession().getAttribute("authUser");
		ArticleData articleData = readArticleService.getArticle(articleNo);

		if (authUser.getMemberid().equals(articleData.getArticle().getWriter().getWriterId())) {
			if (0 < deleteService.delete(articleNo)) {
				return "/WEB-INF/view/deleteSuccess.jsp";
			}
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
		return null;
	}
}
