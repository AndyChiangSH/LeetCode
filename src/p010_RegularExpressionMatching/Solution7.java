// case7: 動態規劃(遞迴版)
package p010_RegularExpressionMatching;

public class Solution7 {

	public static void main(String[] args) {
		Solution7 test = new Solution7();

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
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        
        return dfs(s, p, 0, 0);
    }
    
    private boolean dfs(String s, String p, int sIndex, int pIndex) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        
        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            return (isMatchCharacter(s, p, sIndex, pIndex) && dfs(s, p, sIndex + 1, pIndex)) || dfs(s, p, sIndex, pIndex + 2);
        } else {
            return isMatchCharacter(s, p, sIndex, pIndex) && dfs(s, p, sIndex + 1, pIndex + 1);
        }
        
    }
    
    private boolean isMatchCharacter(String s, String p, int sIndex, int pIndex) {
        if (sIndex == s.length()) {
            return false;
        }
        return s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.';
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
