package jdbc;

import java.sql.DriverManager;

import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInit extends HttpServlet {
	
	@Override
	public void init() {
		
	}
	
	private void loadJDBCDriver() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}
	
	private void initConnectionPool() {
		try {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String username = "jspexam";
			String pw = "java";
			ConnectionFactory connFactory = 
					new DriverManagerConnectionFactory(jdbcUrl,username,pw);
			PoolableConnectionFactory poolableConnFactory = 
					new PoolableConnectionFactory(connFactory, null);
			//커넥션이 유효한지 여부 검사 시 사용할 Query
			poolableConnFactory.setValidationQuery("select 1");
				//커넥션 풀의 설정 정보
				GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
				//유휴 커넥션 검사 주기
				poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5L);//5분
				//풀에 보관중인 커넥션이 유효한지 검사하겠다(true)
				poolConfig.setTestWhileIdle(true);
				//커넥션 최소 개수
				poolConfig.setMinIdle(4);
				//커넥션 최대 개수
				poolConfig.setMaxTotal(50);
			//커넥션 풀을 생성*******
			GenericObjectPool<PoolableConnection> connectionPool = 
					new GenericObjectPool<>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			//커넥션 풀을 제공하는 JDBC 드라이버 등록
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver 
				= (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("chapter14", connectionPool);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}





