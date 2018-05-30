package my;


import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */

public class TwoSum {

	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		HashMap<Integer,Integer> numMap = new HashMap<Integer,Integer>();
        for (int i=0;i < numbers.length; i++) {
        	Integer a = numMap.get(numbers[i]);
        	if (a == null) {
        		numMap.put(numbers[i], i);
        	}
        	
        	int numA = target-numbers[i];
        	a = numMap.get(numA);
        	if (a !=null && a < i) {
        		result[0] = i;
            	result[1] = numMap.get(numA);
            	break;
        	}
        	
        }
        
        return result;
	}
	
	public static void main(String[] args) {
		int[] numbers = new int[]{3,2,4};
		int[] result = twoSum(numbers, 6);
		System.out.println(result[0]);
		System.out.println(result[1]);
		
	}
}