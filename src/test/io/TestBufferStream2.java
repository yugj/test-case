package test.io;

import java.io.*;

public class TestBufferStream2 {
	public static void main(String[] args) {
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			bw = new BufferedWriter(new FileWriter(
					"G:\\tem\\tems.txt"));
			br = new BufferedReader(new FileReader(
					"G:\\tem\\tems.txt"));
			String s = null;
			for (int i = 1; i <= 100; i++) {
				s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				} if(br != null) {
					br.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}