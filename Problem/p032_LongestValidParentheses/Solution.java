package p032_LongestValidParentheses;

import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "())()(()))))()()";
		System.out.println(sol.longestValidParentheses(s));
	}
	
	public int longestValidParentheses(String s) {
		if(s.length() < 2) return 0;
		
		char[] ca = s.toCharArray();
		int len = ca.length;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < len; i++) {
			char c = ca[i];
			if(c == '(') {
				stack.push(i);
			}
			else {
				if(stack.isEmpty() || ca[stack.peek()] == ')') {
					stack.push(i);
				}
				else {
					stack.pop();
				}
			}
		}
		stack.push(len);
		if(stack.isEmpty()) {
			return len;
		}
		else {
			int pre = stack.pop(), max = 0, dif = 0;
			
			System.out.println("pre = "+pre);
			
			while(!stack.isEmpty()) {
				int cur = stack.pop();
				
				System.out.println("cur = "+cur);
				
				dif = pre-cur-1;
				pre = cur;
				if(dif > max) max = dif;
			}
			dif = pre;
			if(dif > max) max = dif;
			
			return max;
		}
    }
}
