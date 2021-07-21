package p032_LongestValidParentheses;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String s = "()(())";
		System.out.println(sol.longestValidParentheses(s));
	}
	
	public int longestValidParentheses(String s) {
		if(s.length() < 2) return 0;
		
		int len = s.length(), max = 0, count = 0;
		int[] dp = new int[len];	// array for dynamic programming
		for(int i = 0; i < len; i++) {
			System.out.println("i = "+i+", count = "+count);
			if(s.charAt(i) == '(') {	// count the number of '('
				count++;
			}
			else if(count > 0) {	// s.charAt(i) == ')'
				// accumulate from previous
				dp[i] = dp[i-1]+2;		// in case of wrapping pair, like "(())"
				System.out.println("i-dp[i] = "+(i-dp[i]));
				if(i-dp[i] >= 0) {	// in case of continuous pair, like "()()"
					dp[i] += dp[i-dp[i]];
				}
				max = Math.max(max, dp[i]);	// get max
				count--;	// delete one pair
			}
			show(dp);
			System.out.println();
		}
		
		return max;
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
