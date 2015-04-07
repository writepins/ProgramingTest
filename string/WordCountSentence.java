package string;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;



public class WordCountSentence{
	private static String sentence = "hello world world today today today";
	
	public static void main(String [] args){
		printStringCount(sentence);
	}
	
	private static void printStringCount(String sentence){
		if (sentence == null || sentence.length() < 1){
			throw new IllegalStateException("sentence is empty");
		}
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		
		int wordStart = 0;
		String token = null;
		for (int i = 0; i <= sentence.length(); i++){
			if (i == sentence.length()){
				if (!map.containsKey(sentence.substring(wordStart, i))){
					map.put(sentence.substring(wordStart, i), 1);
				}else{
					map.put(token, map.get(sentence.substring(wordStart, i)) + 1);
				}
				break;
			}
			
			if (sentence.charAt(i) == ' '){
				token = sentence.substring(wordStart, i);
				if (!map.containsKey(token)){
					map.put(token, 1);
				}else{
					map.put(token, map.get(token) + 1);
				}
				wordStart = i+1;
			}
		}
		printMap(map);
		System.out.println();
		MyClass cl =  new MyClass(map);
		
	} 
	
	private static void printMap(Map<String, Integer> map) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}

class MyClass implements Comparator {
	Map<String, Integer> map;
	
	MyClass(Map<String, Integer> map){
		this.map = map;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return (Integer)(map.get(o2)).compareTo((Integer)map.get(o1));
	}
	
}
