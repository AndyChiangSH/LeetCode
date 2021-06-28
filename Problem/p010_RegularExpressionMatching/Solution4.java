package p010_RegularExpressionMatching;

public class Solution4 {

	public static void main(String[] args) {
		Solution4 test = new Solution4();

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

		String s = "";
		String p = ".*";

		boolean ans = test.isMatch(s, p);
		System.out.println(ans);
	}

	public boolean isMatch(String s, String p) {

		if (s == null || p == null) {
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == s.charAt(i)) {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
