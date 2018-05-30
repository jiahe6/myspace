package my;

public class AddString {
	public String addString(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		
		char[] a0 = a.toCharArray();
		char[] b0 = b.toCharArray();
		
		int carry  = 0;
		String sum = "";
		for (int i =0;(i < aLen) || (i < bLen); i ++) {
			int a1 = i<aLen ? (a0[aLen-1-i]-'0') : 0;
			int b1 = i<bLen ? (b0[bLen-1-i]-'0') : 0;
			
			int temp = a1 + b1 + carry;
			carry = temp /10;
			sum = temp%10 + sum;
		}
		
		if (carry > 0) {
			sum = carry + sum;
		}
		return sum;
	}
}
