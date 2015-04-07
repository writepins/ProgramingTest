package string;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(reverseRecursively("gyan"));
		System.out.println(reverseIterative("gyan"));
	}
	
	//recursive
	public static String reverseRecursively(String str){
		if (str.length() < 2)
			return str;
		return reverseRecursively(str.substring(1)) + str.charAt(0);
	}
	
	//iterative
	public static String reverseIterative(String str){
		if (str.length() < 1)
			return null;
		if (str.length() == 1)
			return str;
		char [] arr = str.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		while (i <= j){
			swap(arr, i, j);
			i++;
			j--;
		}
		return new String(arr);
	}
	
	public static void swap(char [] arr, int i, int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
