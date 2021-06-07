package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//인터페이스 정의 => 모든 명령어 핸들러 클래스가 공통으로 구현해야함
//public class 핸들러 implements commandHandler{
//        public String process(.....)
//				1. 명령어 관련 비즈니스 로직
//				2. 뷰 페이지에서 사용할 정보 저장
//					request.setAttribute("name",value);
//				3. 뷰 페이지의 URI 리턴
//					return "/view/test.jsp";
public interface commandHandler {
	public String process(HttpServletRequest rs, HttpServletResponse res) throws Exception;
}
