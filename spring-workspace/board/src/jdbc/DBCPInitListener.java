package jdbc;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String poolConfig = sce.getServletContext().getInitParameter("poolConfig");
		Properties properties = new Properties();
		try {
			properties.load(new StringReader(poolConfig));
		} catch (IOException e) {
			throw new RuntimeException("config load fail", e);
		}

		loadJDBCDriver(properties);
		initConnectPool(properties);
	}

	private void loadJDBCDriver(Properties properties) {
		String driverClass = properties.getProperty("jdbcdriver");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("fail to load JDBC Driver", e);
		}
	}

	private void initConnectPool(Properties properties) {
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String username = properties.getProperty("dbUser");
		String pw = properties.getProperty("dbPass");

		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(jdbcUrl, username, pw);
		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);

		String validationQuery = properties.getProperty("validationQuery");
		if (validationQuery != null && !validationQuery.isEmpty()) {
			poolableConnectionFactory.setValidationQuery(validationQuery);
		}

		int minIdle = Integer.valueOf(properties.getProperty("minIdle"));
		int maxTotal = Integer.valueOf(properties.getProperty("maxTotal"));
		GenericObjectPoolConfig<PoolableConnection> genericObjectPoolConfig = new GenericObjectPoolConfig<PoolableConnection>();
		genericObjectPoolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60 * 5);
		genericObjectPoolConfig.setTestWhileIdle(true);
		genericObjectPoolConfig.setMinIdle(minIdle);
		genericObjectPoolConfig.setMaxTotal(maxTotal);

		GenericObjectPool<PoolableConnection> genericObjectPool = new GenericObjectPool<PoolableConnection>(poolableConnectionFactory, genericObjectPoolConfig);
		poolableConnectionFactory.setPool(genericObjectPool);

		PoolingDriver poolingDriver = null;
		try {
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			poolingDriver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String poolName = properties.getProperty("poolName");
		poolingDriver.registerPool(poolName, genericObjectPool);
	}
}
