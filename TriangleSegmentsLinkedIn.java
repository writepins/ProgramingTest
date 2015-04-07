import java.util.ArrayList;
import java.util.List;


interface Triangle {

	int [] getTriangleSides(int [] segments);
}

public class TriangleSegmentsLinkedIn implements Triangle {

	private static int [] num = new int[]{1, 2, 3};
	
	public static void main(String [] args){
		TriangleSegmentsLinkedIn tr = new TriangleSegmentsLinkedIn();
		int [] re = tr.getTriangleSides(num);
		System.out.print("");
	}
	
	public int [] getTriangleSides(int [] segments){
		if (segments == null || segments.length < 1){
			throw new IllegalStateException("segment is null or empty");
		}
		
		int i = 0;
		int j = 1;
		int k = 2;
		
		int [] result = {};
		
		for (; k < segments.length; k++){
			if ((segments[i] + segments[j]) > segments[k]){
				System.out.print(segments[i]+" "+segments[j]+" "+segments[k]);
				result[0] = segments[i];
				result[1] = segments[j];
				result[2] = segments[k];
			}
			i++;
			j++;
		}
		return result;
	}
}