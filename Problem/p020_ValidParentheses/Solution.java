package p020_ValidParentheses;

import java.util.Stack;

public class Solution {
	 
	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "[][][])([]";
		System.out.println(sol.isValid(s));
	}
	
	public boolean isValid(String s) {
		if(s == null || s.length() == 0) return true;
		
		Stack st = new Stack();	// use stack
		int len = s.length();
		char[] ca = s.toCharArray();
		
		// scan every char in string
		for(int i = 0; i < len; i++) {
			if(ca[i] == '(' || ca[i] == '[' || ca[i] == '{') {
				st.push(ca[i]);	// '(', '[', '{' push into stack
			}
			else if(ca[i] == ')') {
				if(st.empty()) {
					return false;
				}
				else if((char)st.peek() == '(') {
					st.pop();
				}
				else {
					st.push(ca[i]);
				}
			}
			else if(ca[i] == ']') {
				if(st.empty()) {
					return false;
				}
				else if((char)st.peek() == '[') {
					st.pop();
				}
				else {
					st.push(ca[i]);
				}
			}
			else if(ca[i] == '}') {
				if(st.empty()) {
					return false;
				}
				else if((char)st.peek() == '{') {
					st.pop();
				}
				else {
					st.push(ca[i]);
				}
			}
		}
		
		if(st.empty()) {
			return true;
		}
		return false;
    }
}
