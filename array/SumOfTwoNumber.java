package array;

import java.util.*;

interface TwoSum{
	public void store(int input);
	public boolean test(int test);
}

public class SumOfTwoNumber implements TwoSum{
															
	private List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String [] args){
		SumOfTwoNumber two = new SumOfTwoNumber();
		two.store(1);
		two.store(-2);
		two.store(3);
		two.store(6);
		System.out.println(two.test(5));
	}
	
	@Override
	public void store(int input) {
		// TODO Auto-generated method stub
		list.add(input);
	}

	@Override
	public boolean test(int test) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < list.size(); i++){
			if (!set.contains(test - list.get(i)))
				set.add(list.get(i));
			else{
				System.out.print("("+list.get(i)+","+(test - list.get(i))+")"+",");
				return true;
			}
		}
		return false;
	}
}
