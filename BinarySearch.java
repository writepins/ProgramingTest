
import java.util.HashMap;

public class BinarySearch {
	static int[] num = new int[]{2, 2, 2, 2, 2};
	
	
	public static void  main(String [] args){
		binarySearch(num, 12);
		System.out.println(binarySearchIterative(num, 4));
		findIndex(num, 2);
	}
	
	public static void binarySearch(int [] num, int k){
		if(num.length < 1 || k < num[0] || k > num[num.length-1]) return;
		if(num.length == 1 && num[0] != k) return;
		System.out.println(binarySearch(num, 0, num.length-1, k));
		
	}
	
	//recursive solution
	public static boolean binarySearch(int [] num, int start, int end, int k){

		int midpoint = (start + end) / 2;
		
		if (num[midpoint] > k)
			return binarySearch(num, 0, midpoint-1, k);
		else if(num[midpoint] < k)
			return binarySearch(num, midpoint+1, end, k);
		else if(num[midpoint] == k)
			return true;
		else
			return false;
	}
	   
	//iterative solution
	public static boolean binarySearchIterative(int [] num, int k){
		if(num.length < 1 || k < num[0] || k > num[num.length-1]) return false;
		
		int i = 0;
		int j = num.length - 1;
		while(i <= j){
			int midpoint = (i + j) / 2;
			if (num[midpoint] > k)
				j = midpoint - 1;
			else if (num[midpoint] < k)
				i = midpoint + 1;
			else if (num[midpoint] == k)
				return true;
		}
		return false;
	}
	
	//given a sorted array find the start and end of a particular integer in an array
	//use modified binary search
	
	public static HashMap<Integer, String> findIndex(int [] num,  int k ){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		if(num.length < 1 || k < num[0] || k > num[num.length-1]) return null;
		if(num.length == 1 && num[0] == k){
			map.put(num[0], "(0, 0)");
		}
		
		int start = 0;
		int end = num.length - 1;
		
		if (num[start] == k  && num[end] == k){
			map.put(k, "(start index = "+start+", end index = "+end+")");
			System.out.println(map);
		}
		
		while (start <= end){
		
			int midpoint = (start + end) / 2;
			
			if (num[midpoint] > k)
				end = midpoint - 1;
			else if (num[midpoint] < k)
				start = midpoint + 1;
			else {
				int j = midpoint;
				int i = midpoint;
				while (num[midpoint] == num[i]){
					i--;
					if (i < 0)
						break;
				}
				while (num[midpoint] == num[j]){
					j++;
					if(j == num.length)
						break;
				}
				
				map.put(k, "(start index = "+(i+1)+", end index = "+(j-1)+")");
				System.out.println(map);
				return map;
			}
		}
		return null;	
	}
}