package array;

public class SumOfTwoNumberCloseToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//1. sort the array
	//2. keep track of the minimum
	public static void findTwoNumberSumCloseToZero(int [] num){
		int i = 0;
		int j = num.length - 1;
		int nextsum = 0;
		int minsum = Integer.MAX_VALUE;
		int minIndex = 0;
		int maxIndex = 0;

		while (i < j){	
			nextsum = num[i] + num[j];

			if (Math.abs(nextsum) < Math.abs(minsum)) {
				minsum = nextsum;
				minIndex = i;
				maxIndex = j;
			}

			if (nextsum > 0) j--;
			if (nextsum < 0) i++;
		}
		System.out.println("sum "+minsum);
		System.out.println("i = "+minIndex);
		System.out.println("j = "+maxIndex);
	}

}
