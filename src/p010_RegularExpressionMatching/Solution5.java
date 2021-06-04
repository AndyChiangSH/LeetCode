package p010_RegularExpressionMatching;

public class Solution5 {

	public static void main(String[] args) {
		Solution5 test = new Solution5();

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

		String s = "abbcbba";
		String p = "a*bcb*.*";

//		String s = "";
//		String p = "";

		boolean ans = test.isMatch(s, p);
		System.out.println(ans);
	}

	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		char[] sc = s.toCharArray(), pc = p.toCharArray();
		boolean[][] dp = new boolean[m + 1][n + 1];
		
		showArray(dp, m, n);
		
		// dp table中，dp[i][j]的值代表 s.substring(0, i) 有沒有符合 p.substring(0, j)
		dp[0][0] = true;
		for (int i = 2; i <= n; i++) {
			if (pc[i - 1] == '*') {
				dp[0][i] = dp[0][i - 2];	// 如果*是空字串的話
			}
		}
		
		showArray(dp, m, n);

//		System.out.println("sc[0] = '"+pc[0]+"'");
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (sc[i - 1] == pc[j - 1] || pc[j - 1] == '.') {	// 如果sc等於pc，或 pc等於 "."
					dp[i][j] = dp[i - 1][j - 1];
				} 
				else if (pc[j - 1] == '*') {	// 如果pc等於 "*"
					if (sc[i - 1] == pc[j - 2] || pc[j - 2] == '.') {	// 如果"*"的前一個pc是"."，或前一個sc等於pc
						// "*"代表0個(dp[i][j - 2])，"*"代表1個 (dp[i][j - 1])，或者"*"代表多個 (dp[i - 1][j])
						dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
					} 
					else {
						dp[i][j] = dp[i][j - 2]; // "*"代表0個
					}
				} 
				else {	// 其他狀況都不合
					dp[i][j] = false;
				}
				
				System.out.println("i = "+i+", j = "+j);
				showArray(dp, m, n);
			}
		}

		return dp[m][n];	// dp[m][n]就是答案
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
