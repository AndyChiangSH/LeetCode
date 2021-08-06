package p091_DecodeWays;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String s = "12";
		System.out.println(sol.numDecodings(s));
	}
	
	public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        
        dp[len] = 1;
        for(int i = len-1; i >= 0; i--) {
        	if(s.charAt(i) != '0') {
        		dp[i] += dp[i+1];
        		if(i < len-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
        			dp[i] += dp[i+2];
        		}
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
