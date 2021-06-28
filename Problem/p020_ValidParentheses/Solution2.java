package p020_ValidParentheses;

import java.util.Stack;

public class Solution2 {
	 
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String s = "[][][])([]";
		System.out.println(sol.isValid(s));
	}
	
	public boolean isValid(String s) {
		if(s == null || s.length() == 0) return true;
		Stack st = new Stack();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				st.push(s.charAt(i));
			}
			else if(s.charAt(i) == ')') {
				if(st.empty()) {
					return false;
				}
				else if((char)st.peek() == '(') {
					st.pop();
				}
				else {
					st.push(s.charAt(i));
				}
			}
			else if(s.charAt(i) == ']') {
				if(st.empty()) {
					return false;
				}
				else if((char)st.peek() == '[') {
					st.pop();
				}
				else {
					st.push(s.charAt(i));
				}
			}
			else if(s.charAt(i) == '}') {
				if(st.empty()) {
					return false;
				}
				else if((char)st.peek() == '{') {
					st.pop();
				}
				else {
					st.push(s.charAt(i));
				}
			}
		}
		
		if(st.empty()) {
			return true;
		}
		return false;
    }
}
