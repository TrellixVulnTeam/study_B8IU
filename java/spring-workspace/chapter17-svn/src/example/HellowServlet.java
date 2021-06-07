package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 1) tomcat이 chapter17 웹 어플리케이션을 구동
 * 2) WebServlet 애노테이션 적용된 서블릿 클래스를 찾음
 * 3) 찾았다면, 사용할 서블릿으로 등록
 */
@WebServlet(urlPatterns = "/hello")
public class HellowServlet extends HttpServlet {
	//접근제한자 protectd : 같은 package 객체 및 상속관계의 객체
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//웹 브라우저에 전송될 데이터
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>안녕?서블릿</title></head>");
		out.println("<body>");
		out.println("<h2>반가워 서블릿!</h2>");
		out.println("</body></html>");
	}
}






