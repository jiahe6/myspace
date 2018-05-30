package my;
/** 
 * Given a number represented as an array of digits, plus one to the number. 
 */

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		
		int add = 1;
		for (int i =len-1;i >= 0; i --) {
			int num = digits[i]+add;
			add = num/10;
			digits[i] = num%10;
			
			if (add == 0) {
				return digits;
			}
		}
		
		int[] ret = new int[len+1];
		ret[0] = add;
		
		for (int k =0;k<len;k++) {
			ret[k+1] = digits[k];
		}
		
		return ret;
	}
}