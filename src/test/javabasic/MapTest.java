package test.javabasic;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("1", "java");
		map.put("c++", "c++");
		System.out.println(map.get("c++"));
	}

}
