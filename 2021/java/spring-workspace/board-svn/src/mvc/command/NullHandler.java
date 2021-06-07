package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements commandHandler {

	@Override
	public String process(HttpServletRequest rs, HttpServletResponse res) throws Exception {
		
		return "/view/nullCommand.jsp";
	}

}
