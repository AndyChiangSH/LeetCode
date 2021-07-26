// solution3: greedy
package p044_WildcardMatching;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String s = "acdcb", p = "a*c?b";
		System.out.println(sol.isMatch(s, p));
	}
	
	public boolean isMatch(String s, String p) {
		int s_len = s.length(), p_len = p.length();
		int i = 0, j = 0, last_match = -1, star = -1;
		
		System.out.println("s = "+s);
		System.out.println("p = "+p);
		while(i < s_len) {
			System.out.print("i = "+i+", j = "+j+", last_match = "+last_match+", star = "+star);
			if(j < p_len && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {	// if s[i] == p[j] or p[j] is '?'
				i++;
				j++;
			}
			else if(j < p_len && p.charAt(j) == '*') {	// if p[j] is star
				star = j;	// store last star position
				j++;
				last_match = i;	// store index of last match
			}
			else if(star != -1) {	// there is a star
				j = star + 1;
				last_match++;
				i = last_match;
			}
			else {
				return false;
			}
			System.out.println(" -> i = "+i+", j = "+j+", last_match = "+last_match+", star = "+star);
		}
		while(j < p_len && p.charAt(j) == '*') {
			j++;
		}
		
		return j == p_len;
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
