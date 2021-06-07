package g_exception;

public class Exception_06 {
	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			deleteFiles();
		}
	}
	
	static void startInstall() {
		
	}
	
	static void copyFiles() {
		
	}
	
	static void deleteFiles() {
		
	}
}
