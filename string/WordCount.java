package string;


import java.util.StringTokenizer;

public class WordCount {

	private static String word = "my  name is    gyan";
	public static void main(String [] args){
		System.out.println(countWordsInString(word));
	}
	
	public static int countWordsInString(String word){
		int count = 0;
		StringTokenizer st = new StringTokenizer(word, " ");
		StringBuffer sb = new StringBuffer();
		while(st.hasMoreElements()){
			String nextToken = st.nextToken();
			count++;
			sb.append(nextToken).append(" ");
		}
		System.out.println(sb.toString().trim());
		return count;
	}
}
