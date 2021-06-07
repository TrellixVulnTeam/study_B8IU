package mvc.controller;

import java.io.FileNotFoundException;
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

import mvc.command.CommandHandler;

public class ControllerUsingURI extends HttpServlet {
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<String, CommandHandler>();

	public ControllerUsingURI() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		Properties properties = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(configFilePath);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		Iterator<Object> keyIter = properties.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = properties.getProperty(command);

			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
			} catch (InstantiationException e) {
				e.printStackTrace();
				throw new ServletException(e);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				throw new ServletException(e);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI();
		if (command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
		CommandHandler handler = commandHandlerMap.get(command);
//		if (handler == null) {
//			handler = new NullHandler();
//		}

		String viewPage = null;
		viewPage = handler.process(request, response);

		if (viewPage != null) { 
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
