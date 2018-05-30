package my;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ?
 * c) The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		// 排序
		Arrays.sort(num);
		
		HashSet<List<Integer>> resSet = new HashSet<List<Integer>>();
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		for (int i =0; i < num.length-2; i ++) {
			int start = i+1;
			int end = num.length -1;
			
			while (start < end) {
				
				if (num[i] + num[start] + num[end] == 0) {
					LinkedList<Integer> res0 = new LinkedList<Integer>();
					res0.add(num[i]);
					res0.add(num[start]);
					res0.add(num[end]);
					
					resSet.add(res0);
					
					start ++;
					end --;
				} else if (num[i] + num[start] + num[end] < 0) {
					start ++;
				} else if (num[i] + num[start] + num[end] > 0) {
					end --;
				}
			}
		}
		
		result.addAll(resSet);
		
		return result;
	}
}