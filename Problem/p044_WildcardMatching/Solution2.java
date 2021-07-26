// solution2: dynamic programming begin with $
package p044_WildcardMatching;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String s = "a", p = "a*";
		System.out.println(sol.isMatch(s, p));
	}
	
	public boolean isMatch(String s, String p) {
		s = '$' + s;	// set empty s as $
		p = '$' + p;	// set empty p as $
        int s_len = s.length(), p_len = p.length();
        boolean[][] dp = new boolean[s_len][p_len];
        
        dp[0][0] = true;
        for(int i = 1; i < p_len; i++) {
        	if(p.charAt(i) != '*') break;
        	dp[0][i] = true;
		}
		for(int i = 1; i < s_len; i++) {
			for(int j = 1; j < p_len; j++) {
				if(p.charAt(j) == '?') {
					dp[i][j] = dp[i-1][j-1];
				}
				else if(p.charAt(j) == '*') {
//					System.out.println("i = "+i+", j = "+j+", or = "+(dp[i-1][j] || dp[i][j-1]));
					dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
				}
				else if(p.charAt(j) == s.charAt(i)) {
					dp[i][j] = dp[i-1][j-1];
				}
			}
		}
		show(dp, s, p);
		
		return dp[s_len-1][p_len-1];
    }
	
	// show int 2D-array
	private void show(boolean[][] A, String s, String p) {
		
		System.out.print("  ");
		for(int i = 0; i < p.length(); i++) {
			System.out.print(p.charAt(i)+" ");
		}
		System.out.println();
		
		for(int i = 0; i < A.length; i++) {
			System.out.print(s.charAt(i)+" ");
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
