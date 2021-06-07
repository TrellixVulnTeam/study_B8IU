package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//HttpServlet? 서블릿을 위한 상위 클래스
public class OracleDriverLoader extends HttpServlet {
	//JDBC드라이버는 한 번만 로딩하면 계속 사용할 수 있음
	//서블릿 클래스 사용(OracleDriverLoader)
	//서블릿을 초기화할 때 호출되는 메서드. 서블릿을 초기화할 때 최초 1회 실행
	@Override
	public void init(ServletConfig config) throws ServletException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {
			throw new ServletException(ex);
		}
	}
	
}
