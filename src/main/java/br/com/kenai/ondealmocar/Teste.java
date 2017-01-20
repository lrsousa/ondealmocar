package br.com.kenai.ondealmocar;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

public class Teste {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("leonardo", 1);
		
		if(map.containsKey("leonardo")) {
			map.merge("leonardo", 1, Integer::sum);
		}
		if(map.containsKey("leonardo")) {
			map.merge("leonardo", 1, Integer::sum);
		}
		if(map.containsKey("leonardo")) {
			map.merge("leonardo", 1, Integer::sum);
		}
		if(map.containsKey("leonardo")) {
			map.merge("leonardo", 1, Integer::sum);
		}
		if(map.containsKey("leonardo")) {
			map.merge("leonardo", 1, Integer::sum);
		}
		if(map.containsKey("kenai")) {
			map.merge("kenai", 1, Integer::sum);
		} else {
			map.put("kenai", 1);
		}
		
		
		
		JSONArray ja = new JSONArray();
		ja.put(map);
		
		System.out.println(ja.toString().replace("{", "[").replace("}", "]").replace(",", "],[").replace(":", ","));
		
	}
}
