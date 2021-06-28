package p010_RegularExpressionMatching;

public class Solution6 {

	public static void main(String[] args) {
		Solution6 test = new Solution6();

//		String s = "aa";
//		String p = "a";

//		String s = "aa";
//		String p = "a*";

//		String s = "ab";
//		String p = ".*";

//		String s = "aab";
//		String p = "c*a*b";

//		String s = "mississippi";
//		String p = "mis*is*p*.";

//		String s = "ababaaabcacbaaa";
//		String p = "ab.*a*b..*b.*..a";

//		String s = "abbcbba";
//		String p = "a*bcb*.*";

		String s = "aab";
		String p = "a*.*b";

		boolean ans = test.isMatch(s, p);
		System.out.println(ans);
	}

	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		char[] sc = s.toCharArray(), pc = p.toCharArray();
		boolean[][] dp = new boolean[m + 1][n + 1];
		
		dp[0][0] = true;
		for (int i = 2; i <= n; i++) {
			if (pc[i - 1] == '*') {
				dp[0][i] = dp[0][i - 2];
			}
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (sc[i - 1] == pc[j - 1] || pc[j - 1] == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} 
				else if (pc[j - 1] == '*') {
					if (sc[i - 1] == pc[j - 2] || pc[j - 2] == '.') {
						dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
					} 
					else {
						dp[i][j] = dp[i][j - 2];
					}
				} 
			}
		}

		return dp[m][n];
	}
	
	private void showArray(boolean[][] arr, int s, int p) {
		System.out.print("  ");
		for(int j = 0; j <= p; j++) {
			System.out.printf("%2d", j);
		}
		System.out.println();
		for(int i = 0; i <= s; i++) {
			
			System.out.printf("%2d", i);
			for(int j = 0; j <= p; j++) {
				System.out.printf("%2c", arr[i][j] ? 'T' : 'F');
			}
			System.out.println();
		}
	}
}
