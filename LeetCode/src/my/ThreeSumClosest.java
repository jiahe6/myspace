package my;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is
 * closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		
		int res = num[0]+num[1]+num[2];
		int dif = Math.abs(res-target);
		for (int i =0; i < num.length-2; i ++) {
			int start = i+1;
			int end = num.length -1;
			
			while (start < end) {
				
				int temp = num[i] + num[start] + num[end];
				if (Math.abs(temp-target) < dif) {
					dif = Math.abs(temp-target);
					res = temp;
					
				} 
				
				if (temp < target) {
					start ++;
				}
				
				if (temp > target) {
					end --;
				}
			}
		}
		return res;
	}
}
