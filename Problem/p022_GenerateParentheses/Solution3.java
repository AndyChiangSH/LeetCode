// DP solution

package p022_GenerateParentheses;

import java.util.ArrayList;

public class Solution3 {
	
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int n = 4;
		ArrayList<String> ans = sol.generateParenthesis(n);
		
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
		System.out.println(ans.size());
	}
	
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < n+1; i++) {
			ans.add(new ArrayList<String>());
		}
		
		ans.get(0).add("");
		for(int i = 0; i < n+1; i++) {
			ArrayList<String> list = ans.get(i);
			for(int j = 0; j < i; j++) {
				ArrayList<String> x = ans.get(j);
				ArrayList<String> y = ans.get(i-j-1);
				for(int k = 0; k < x.size(); k++) {
					for(int l = 0; l < y.size(); l++) {
						list.add("("+x.get(k)+")"+y.get(l));
					}
				}
			}
		}
		
		return ans.get(n);
	}
}
