package homework;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
	/*
	 * public String solution(String s) { String[] arr = s.split(" "); BigDecimal
	 * min = new BigDecimal(Double.MAX_VALUE); BigDecimal max = new
	 * BigDecimal(Double.MIN_VALUE); for (String num : arr) { BigDecimal n = new
	 * BigDecimal(num); if (n.compareTo(min) < 0) { min = n; } if (n.compareTo(max)
	 * > 0) { max = n; } } List<BigDecimal> list = new ArrayList<BigDecimal>();
	 * for(String num2 : arr) { list.add(new BigDecimal(num2)); }
	 * 
	 * Collections.sort(list);
	 * 
	 * for(BigDecimal number : list) { System.out.println(" number : " + number); }
	 * return list.get(0) + " " + list.get(list.size()-1); }
	 */
	
	 public int solution(int[] A, int[] B) {
		
		  
	      Arrays.sort(A);
	      Arrays.sort(B);
	      int length = A.length;
	      int sum = 0;
	      for (int i = 0; i < length; i++) {
	          sum += A[i] * B[length - i - 1];
	      }

		System.out.println("Hello Java");

	      return sum;
	  }
    
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		/*
		 * System.out.println(solution.
		 * solution("111111111111111111111111111111111111111111111111111111 1233"));
		 */
		
			int[]A = {1001,2002};
			int[]B = {5,4,4};
	
		
		
		System.out.println(solution.solution(A, B));
	}

}

