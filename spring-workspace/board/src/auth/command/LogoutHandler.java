package auth.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/loginForm.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return null;
	}

}
