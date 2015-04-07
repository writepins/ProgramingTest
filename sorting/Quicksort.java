package sorting;

public class Quicksort {

	static int[] arr = {1, 3, 5, 2, 4, 6};
	public static void main(String [] args) {
		quickSort(arr, 0, arr.length - 1);
		System.out.println();
		System.out.println("sorted arr : ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+",");
	}
	
	public static void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}
	
	static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	      System.out.println("pivot : "+pivot);
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	            	System.out.println("swapping "+arr[i] + " with "+arr[j]);
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      System.out.println("index i : "+i+" with arr value "+arr[i]);
	      System.out.println("----------------------------------------------");
	      return i;
	}
}


