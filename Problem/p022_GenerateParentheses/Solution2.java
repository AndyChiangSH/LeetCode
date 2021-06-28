package p022_GenerateParentheses;

import java.util.ArrayList;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int n = 8;
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
		if(r > l || l > n) return;
		if(l == n && r == n) {
			ans.add(sb.toString());
			return;
		}
		
		dfs(ans, new StringBuilder(sb.append("(")), l+1, r, n);
		sb.deleteCharAt(sb.length()-1);
		dfs(ans, new StringBuilder(sb.append(")")), l, r+1, n);
		
		return;
	}
}
