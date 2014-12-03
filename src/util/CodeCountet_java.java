package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeCountet_java {
	static long normalLines = 0;
	static long commentLines = 0;
	static long whiteLines = 0;
	
	public static void main(String[] args) {
		new CodeCountet_java().dirCount(new File("F:\\src\\modbus4j-master\\modbus4j-master\\Modbus4J"));
		System.out.println("normalLines:" + normalLines);
		System.out.println("commentLines:" + commentLines);
		System.out.println("whiteLines:" + whiteLines);
		long total = normalLines + commentLines + whiteLines;
		System.out.println("total:" + total);
	}
	//计算一个目录下面的java文件的代码数
	private void manager(File f) {
		File[] childs = f.listFiles();
		for (File child : childs) {
			if (child.getName().matches(".*\\.java$")) {
				count(child);
			}
		}
	}
	
	//计算单个java文件里面的代码数
	private void count(File f) {
		BufferedReader br = null;
		boolean comment = false;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (line.matches("^[\\s\\t]*")) {
					whiteLines++;
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					commentLines++;
					comment = true;
				} else if (true == comment) {
					commentLines++;
					if (line.endsWith("*/")) {
						comment = false;
					}
				} else if (line.startsWith("/*") && line.endsWith("*/")) {
					commentLines++;
				} else if (line.startsWith("//")) {
					commentLines++;
				} else {
					normalLines++;
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void dirCount(File f) {
		if(!f.isDirectory()) return;
		manager(f);
		File[] childs = f.listFiles();
		for(int i=0; i<childs.length; i++) {
			dirCount(childs[i]);
		}
		
		
	}
}
