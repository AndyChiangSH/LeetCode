// solution1: dynamic programming
package p044_WildcardMatching;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "", p = "";
		System.out.println(sol.isMatch(s, p));
	}
	
	public boolean isMatch(String s, String p) {
        int s_len = s.length(), p_len = p.length();
        boolean[][] dp = new boolean[s_len+1][p_len+1];	// 2D array for dynamic programming
        
        dp[0][0] = true;
        for(int i = 0; i < p_len; i++) {	// first row is empty s only match *
        	if(p.charAt(i) != '*') break;
        	dp[0][i+1] = true;
		}
		for(int i = 0; i < s_len; i++) {
			for(int j = 0; j < p_len; j++) {
				if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {	// if s[i] == p[j] or p[j] is '?', then get value from left top
					dp[i+1][j+1] = dp[i][j];
				}
				else if(p.charAt(j) == '*') {	// if p[j] is star, then get value from top or left
					dp[i+1][j+1] = (dp[i][j+1] || dp[i+1][j]);
				}
			}
		}
		show(dp, s, p);
		
		return dp[s_len][p_len];
    }
	
	// show int 2D-array
	private void show(boolean[][] A, String s, String p) {
		
		System.out.print("  $ ");
		for(int i = 0; i < p.length(); i++) {
			System.out.print(p.charAt(i)+" ");
		}
		System.out.println();
		
		for(int i = 0; i < A.length; i++) {
			if(i == 0) 
				System.out.print("$ ");
			else
				System.out.print(s.charAt(i-1)+" ");
			
			for(int j = 0; j < A[i].length; j++) {
				if(A[i][j])
					System.out.print("T");
				else
					System.out.print("F");
				if(j != A[i].length-1) {
					System.out.print(" ");
				}
			}
			if(i != A.length-1) {
				System.out.println("");
			}
		}
		System.out.println();
	}
}
