package auth.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/loginForm.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else if (request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return FORM_VIEW;
		}
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String memberid = request.getParameter("memberid");
		String password = request.getParameter("password");

		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		request.setAttribute("errors", errors);

		if (memberid == null || memberid.isEmpty()) {
			errors.put("memberid", Boolean.TRUE);
		}
		if (password == null || password.isEmpty()) {
			errors.put("password", Boolean.TRUE);
		}
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			User user = LoginService.getInstance().login(memberid, password);
			request.getSession().setAttribute("authUser", user);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return null;
		} catch (RuntimeException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
}
