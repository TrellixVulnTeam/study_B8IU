package member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.ChangePasswordService;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

public class ChangePasswordHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/changePasswordForm.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = (User)request.getSession().getAttribute("authUser");
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		
		String currentPassword = request.getParameter("currrentPasswords");
		String newPassword = request.getParameter("newPassword");
		
		if (currentPassword == null || currentPassword.isEmpty()) {
			errors.put("currentPasswordEmpty", Boolean.TRUE);
		}
		
		if (newPassword == null | newPassword.isEmpty()) {
			errors.put("newPasswordEmpty", Boolean.TRUE);
		}
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			ChangePasswordService.getInstance().changePassword(user.getMemberid(), currentPassword, newPassword);
			
			return "/WEB-INF/view/changePasswordSuccess.jsp";
		} catch (MemberNotFoundException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		} catch (InvalidPasswordException e) {
			errors.put("invalidPassword", Boolean.TRUE);
		}
		return FORM_VIEW;
	}
}
