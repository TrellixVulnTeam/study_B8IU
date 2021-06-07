package article.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.Article;
import article.service.ArticlePage;
import article.service.ListArticleService;
import mvc.command.commandHandler;

public class ListArticleHandler implements commandHandler{

	private ListArticleService listService = new ListArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		//pageNo 파라미터가 있으면 pageNo에 넣어줌
		if(pageNoVal!=null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		ArticlePage articlePage = listService.getArticlePage(pageNo);
		System.out.println("articlePage : " + articlePage.toString());
		req.setAttribute("articlePage", articlePage);
		
		return "/WEB-INF/view/listArticle.jsp";
	}
	
}


