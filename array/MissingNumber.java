package array;

public class MissingNumber {

	public static void main(String [] args){
//		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18 ,19, 20};
//		int[] arr = new int []{1, 2, 3, 5, 6};
		int[] arr = new int []{3,1,4,5};
//		findMissingNumber(arr);
		System.out.println(getMissingNo(arr, 4));
	}

	
/*
 *1) XOR all the array elements, let the result of XOR be X1.
  2) XOR all numbers from 1 to n, let XOR be X2.
  3) XOR of X1 and X2 gives the missing number.
 */
	private static int getMissingNo(int a[], int n)
	{
	    int i;
	    int x1 = a[0]; /* For xor of all the elemets in arary */
	    int x2 = 1; /* For xor of all the elemets from 1 to n+1 */
	     
	    for (i = 1; i< n; i++){
	        x1 = x1^a[i];
	    }
	            
	    for ( i = 2; i <= n+1; i++){
	        x2 = x2^i;         
	    }
	    
	    return (x1^x2);
	}
}