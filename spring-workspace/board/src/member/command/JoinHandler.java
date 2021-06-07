package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		request.setAttribute("errors", errors);

		JoinRequest joinRequest = new JoinRequest();
		joinRequest.setId(request.getParameter("id"));
		joinRequest.setName(request.getParameter("name"));
		joinRequest.setPassword(request.getParameter("password"));
		joinRequest.setConfirmPassword(request.getParameter("confirmPassword"));
		joinRequest.validate(errors);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			JoinService.getInstance().join(joinRequest);
			return "/WEB-INF/view/joinSuccess.jsp";
		} catch (DuplicateIdException e) {
			return FORM_VIEW;
		}
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}
}
