package string;

import java.util.StringTokenizer;



public class DistanceBetweenStringWords {
	public static void main(String [] args){
		int distance = getDistanceBetweenTwoWords("The picture quality is great of this camera", "quality", "thiss");
		System.out.println(distance);
	}
	
	private static int getDistanceBetweenTwoWords(String word, String token1, String token2){
		if (word == null || word.length() < 1 || token1.length() < 1){
			return -1;
		}
		
		if ((word.indexOf(token1) == -1) || (word.indexOf(token2) == -1)){
			return -1;
		}
		
		int wordCount = 0;
		StringTokenizer st = new StringTokenizer(word);
		String nextToken = null;
		boolean start = false;
		
		while(st.hasMoreTokens()){
			nextToken = st.nextToken();
			if (nextToken.equals(token1)){
				start = true;
				continue;
			}
			
			if (start){
				if (nextToken.equals(token2)){
					start = false;
				}else {
					wordCount++;
				}
			}
		}
		return wordCount;
	}
}
