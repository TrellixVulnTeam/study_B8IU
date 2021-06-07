package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpSession session = request.getSession(false);
		//세션이 없거나 || 세션에 "authUser" 속성이 없으면
		if(session == null || session.getAttribute("authUser")==null) {
			HttpServletResponse response = (HttpServletResponse)res;
			//request.getContextPath() : /board
			response.sendRedirect(request.getContextPath() + "/login.do");
		}else { //세션이 authUser 속성이 존재=>로그인함
			chain.doFilter(req, res);
		}
	}
	@Override
	public void init(FilterConfig config) throws ServletException{}
	@Override
	public void destroy() {}
}



