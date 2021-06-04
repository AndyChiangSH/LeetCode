package p010_RegularExpressionMatching;

public class Solution3 {

	public static void main(String[] args) {
		Solution3 test = new Solution3();

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
		String p = "c*a*b";

		boolean ans = test.isMatch(s, p);
		System.out.println(ans);
	}

	public boolean isMatch(String s, String p) {
		// if p is empty, answer is True when s is not empty. 
		if(p == null || p.length() == 0)
			return (s == null || s.length() == 0);

		boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;	// s and p are both empty is True
		for(int j = 2; j <= p.length(); j++) {	// create first column
			dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
		}

		for(int j = 1; j <= p.length(); j++) {
			for(int i = 1; i <= s.length(); i++) {
				if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')
					dp[i][j] = dp[i - 1][j - 1];
				else if(p.charAt(j - 1) == '*')
					dp[i][j] = dp[i][j - 2]
							|| ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
			}
		}
		
		System.out.print("  ");
		for(int j = 0; j <= p.length(); j++) {
			System.out.printf("%2d", j);
		}
		System.out.println();
		for(int i = 0; i <= s.length(); i++) {
			
			System.out.printf("%2d", i);
			for(int j = 0; j <= p.length(); j++) {
				System.out.printf("%2c", dp[i][j] ? 'T' : 'F');
			}
			System.out.println();
		}
		
		return dp[s.length()][p.length()];
	}
}
