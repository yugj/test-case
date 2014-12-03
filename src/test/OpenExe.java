package test;

import java.io.IOException;

public class OpenExe {

	public static void main(String[] args) {
		new OpenExe().run();
	}

	public void run() {
		String userHome = System.getProperty("user.home");
		String clientLocate = "java -jar " + userHome + "/plc/PLClient.jar";
		try {
			Runtime.getRuntime().exec(clientLocate);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
