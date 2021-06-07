package g_exception;

import java.sql.SQLException;

public class Exception_05 {
	public static void main(String[] args) {
		Controller.controllerMethod();
	}
}

class Controller {
	static void controllerMethod() {
		Service.serviceMethod();
	}
}

class Service {
	static void serviceMethod() {
		try{
			Dao.daoMethod();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("상빈이 때문에..아오...");
		}
	}
	
}

class Dao {
	static void daoMethod() throws SQLException {
		
		throw new SQLException();
	}
}
