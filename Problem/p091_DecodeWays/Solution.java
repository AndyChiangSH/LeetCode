package p091_DecodeWays;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "0000";
		System.out.println(sol.numDecodings(s));
	}
	
	public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        
        dp[len] = 1;	// extra space to put tail 1
        if(s.charAt(len-1) != '0') {	// last char is not 0
        	dp[len-1] = 1;
        }
        for(int i = len-2; i >= 0; i--) {
        	if(s.charAt(i) == '0') {	// 00~09
        		dp[i] = 0;
        	}
        	else if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')) {	// 10~26
        		dp[i] = dp[i+1] + dp[i+2];
        	}
        	else {	// > 26
        		dp[i] = dp[i+1];
        	}
        }
        
        show(dp);
        return dp[0];
    }
	
	// show int 1D-array
	private void show(int A[]) {
		int len = A.length;
		System.out.print("[");
		for(int i = 0; i < len; i++) {
			System.out.print(A[i]);
			if(i != len-1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
