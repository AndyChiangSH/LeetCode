package c20210628_RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String str = "a";
		System.out.println(sol.removeDuplicates(str));
	}
	
	public String removeDuplicates(String s) {
        if(s == null || s == "") return new String();
        
        Stack st = new Stack();	// use stack
		char[] ca = s.toCharArray();
		int len = ca.length;
		
		for(int i = 0; i < len; i++) {
			if(st.isEmpty()) {
				st.push(ca[i]);
			}
			else {
				if((char) st.peek() == ca[i]) {
					st.pop();
				}
				else {
					st.push(ca[i]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		return sb.reverse().toString();
    }
}
