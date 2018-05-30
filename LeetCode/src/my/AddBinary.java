package my;



/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 */

public class AddBinary {
	public String addBinary(String a, String b) {
		int aLen = a.length()-1;
		int bLen = b.length()-1;
		
		int flag = 0;
		String sum = "";
		while (aLen > 0 && bLen > 0) {
			int num = (a.charAt(aLen)-'0') + (b.charAt(bLen)-'0') + flag;
			flag = num /2;
			sum = (char)(num % 2+'0')+sum;
			
			aLen --;
			bLen --;
			
		}
		while (aLen > 0) {
			int num = (a.charAt(aLen)-'0') + flag;
			flag = num /2;
			sum = (char)(num % 2+'0')+sum;
			
			aLen --;
		}
		while (bLen > 0) {
			int num = (b.charAt(bLen)-'0') + flag;
			flag = num /2;
			sum = (char)(num % 2+'0')+sum;
			
			bLen --;
		}
		
		if (flag > 0) {
			sum = (char)(flag+'0')+sum;
		}
		return sum;
	}
}