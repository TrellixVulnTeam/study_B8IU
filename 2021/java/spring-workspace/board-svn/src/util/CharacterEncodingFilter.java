package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//jsp에서 request.setCharacterEncoding("UTF-8")
//요청 파라미터의 캐릭터 인코딩을 한 곳에서 설정=>필터 사용(소스 중복 최소화)
public class CharacterEncodingFilter implements Filter {
	private String encoding;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException{
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, res);
	}
	//초기화 파라미터를 이용해서 사용할 인코딩 지정
	//필터 매핑을 통해서 어떤 URL 패턴에 필터를 적용할지 지정
	@Override
	public void init(FilterConfig config) throws ServletException{
		encoding = config.getInitParameter("encoding");
		if(encoding == null) {
			encoding = "UTF-8";
		}
	}
	@Override
	public void destroy() {
		
	}
}



