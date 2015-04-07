package array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueElement {
	private static int [] num = new int[]{5,2,7,2,4,7,8,2,3};
	
	public static void main(String [] args){
		System.out.println(getUniqueElements(num));
	} 
	
	private static Set<Integer> getUniqueElements(int [] num){
		if (num == null || num.length < 1){
			return null;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++){
			if (!set.contains(num[i])){
				set.add(num[i]);
			}
		}
		return set;
	}
	
	public static void remove(Set<Integer> set){
		Iterator it = set.iterator();
		while(it.hasNext()){
			it.remove();
		}
	}
}
