package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlighScheduling {

	public static void main(String[] args) {
		getFlightSchedule(new int[] {900,940,950,1100,1500,1800}, new int[]{910,1200,1120,1130,1900,2000});
	}
	
	public static int getFlightSchedule(int[] arr, int[] dep) {
		int i = 0;
		List<Integer> lst = new ArrayList<Integer>();
		for(i = 0 ; i < arr.length; i++) {
			lst.add(arr[i]);
		}
		
		for(i = 0 ; i < arr.length; i++) {
			lst.add(dep[i]);
		}
		
		Collections.sort(lst);
		
		for(int j : lst) {
			System.out.print(j + " ");
		}
		
		return i;
	}

}
