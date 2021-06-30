package p029_DivideTwoIntegers;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.divide(2147483647, 2147483647));
		
//		int a = -2147483648;
//		int b = Math.abs(a);
//		System.out.println("b = "+b);
	}
	
	public int divide(int dividend, int divisor) {       
        if(dividend ==  Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        if(dividend > 0) dividend = -dividend;
        if(divisor > 0) divisor = -divisor;
           
        return isNeg? -div(dividend, divisor) : div(dividend, divisor);
    }
	
    public int div(int divid, int divis){
        if(divid > divis) return 0;
        int curSum = divis << 1, prevSum = divis, q = 1;
        
        while(divid <= curSum && curSum < prevSum){
            prevSum = curSum;
            curSum <<= 1; q <<= 1;
        }
        return q + div(divid - prevSum, divis);
    }
}
