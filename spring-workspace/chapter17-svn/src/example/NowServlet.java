package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;

public class NowServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		//response 객체를 이용해서 응답(=page 디렉티브의 contentType 속성과 동일)
		response.setContentType("text/html;charset=UTF-8");
		//응답 데이터를 생성하고 전달.
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>현재시간</title></head>");
		out.println("<body>현재 시간은");
		out.println(new Date());
		out.println("입니다.");
		out.println("</body></html>");
	}
}





