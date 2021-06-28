package p022_GenerateParentheses;

import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 3;
		ArrayList<String> ans = sol.generateParenthesis(n);
		
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
		System.out.println(ans.size());
	}
	
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> ans = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		dfs(ans, sb, 0, 0, n);
		
		return ans;
    }
	
	private void dfs(ArrayList<String> ans, StringBuilder sb, int l, int r, int n) {
		if(l == n && r == n) {
			ans.add(sb.toString());
			return;
		}
		
		if(l < n) {
			dfs(ans, sb.append("("), l+1, r, n);
			sb.setLength(sb.length()-1);
		}
		if(r < l) {
			dfs(ans, sb.append(")"), l, r+1, n);
			sb.setLength(sb.length()-1);
		}
	}
}
