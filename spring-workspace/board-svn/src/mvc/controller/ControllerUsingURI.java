package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.NullHandler;
import mvc.command.commandHandler;

//.jsp => .do확장자 사용. 
//.do 요청 => 서블릿이 처리하도록 함
public class ControllerUsingURI extends HttpServlet {
	//<커맨드, 핸들러인스턴스>
	private Map<String, commandHandler> commandHandlerMap = new HashMap<>();
	
	public void init() throws ServletException{
		///WEB-INF/commandHandlerURI.properties
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		//D:\A_TeachingMaterial\6.JspSpring\workspace\board\WebContent\WEB-INF\commandHandlerURI.properties
		String configFilePath = getServletContext().getRealPath(configFile);
		try(FileReader fis = new FileReader(configFilePath)){
			prop.load(fis);
		}catch(IOException e) {
			throw new ServletException(e);
		}
		
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();	// /join.do
			String handlerClassName = prop.getProperty(command);	//member.command.JoinHandler
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				commandHandler handlerInstance = (commandHandler)handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
				System.out.println("commandHandlerMap : " + commandHandlerMap);
			}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException{
		process(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		///board/join.do
		String command = request.getRequestURI();
		System.out.println("command : " + command);
		///board
		System.out.println("request.getContextPath() : " + request.getContextPath());
		if(command.indexOf(request.getContextPath())==0){
			//command : /join.do
			command = command.substring(request.getContextPath().length());
			System.out.println("command : substring : " + command);
		}
		System.out.println("commandHandlerMap : " + commandHandlerMap);
		System.out.println("command : " + commandHandlerMap.get(command));
		///join.do -> member.command.JoinHandler. 
		commandHandler handler = commandHandlerMap.get(command); 
//		if(handler==null) {
//			handler = new NullHandler();
//		}
		
		String viewPage = null;
		try {
			//viewPage : "/WEB-INF/view/joinForm.jsp"
			viewPage = handler.process(request, response);
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}






