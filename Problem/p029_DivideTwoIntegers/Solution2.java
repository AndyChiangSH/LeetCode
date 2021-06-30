package p029_DivideTwoIntegers;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		System.out.println(sol.divide(2147483647, 2147483647));
		
//		int a = -2147483648;
//		int b = Math.abs(a);
//		System.out.println("b = "+b);
	}
	
	public int divide(int dividend, int divisor) {
		boolean pos = (dividend<0) == (divisor<0);
		if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
		if(divisor == Integer.MIN_VALUE) return 0;
		
		int q = 0, dvs = Math.abs(divisor);
		if(dividend >= 0) {
			while(dividend >= dvs) {
				dividend -= dvs;
	        	q++;
	        }
		}
		else {
			while(dividend <= -dvs) {
				dividend += dvs;
	        	q++;
	        }
		}
        if(pos) return q;
        else return -q;
    }
}
