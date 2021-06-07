package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ExceptionLogger {
	private static ExceptionLogger exceptionLogger = new ExceptionLogger();

	Logger logger;
	FileHandler fileHandler;
	SimpleFormatter sformatter;

	public static ExceptionLogger getInstance() {
		return exceptionLogger;
	}

	private ExceptionLogger() {
		logger = Logger.getLogger(ExceptionLogger.class.getName());
		logger.setLevel(Level.ALL);

		try {
			fileHandler = new FileHandler("./log/%u.%g.log", 1024 * 1024, 10, true);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileHandler.setLevel(Level.ALL);
		sformatter = new SimpleFormatter();
		fileHandler.setFormatter(sformatter);
		logger.addHandler(fileHandler);
	}

	public void infoLogger(String str) {
		logger.info(str);
		logger.log(Level.INFO, str);
	}

	public void infoLogger(Exception ex) {
		logger.info(ex.getMessage());
		logger.log(Level.INFO, ex.getMessage());
	}

	public void warningLogger(String str) {
		logger.warning(str);
		logger.log(Level.WARNING, str);
	}

	public void warningLogger(Exception ex) {
		logger.warning(ex.getMessage());
		logger.log(Level.WARNING, ex.getMessage());
	}

	public void severeLogger(String str) {
		logger.severe(str);
		logger.log(Level.SEVERE, str);
	}

	public void severeLogger(Exception ex) {
		logger.severe(ex.getMessage());
		logger.log(Level.SEVERE, ex.getMessage());
	}

	public void fineLogger(String str) {
		logger.fine(str);
		logger.log(Level.FINE, str);
	}

	public void fineLogger(Exception ex) {
		logger.fine(ex.getMessage());
		logger.log(Level.FINE, ex.getMessage());
	}
}
