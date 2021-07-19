package p032_LongestValidParentheses;

import java.util.Stack;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String s = "(()";
		System.out.println(sol.longestValidParentheses(s));
	}
	
	public int longestValidParentheses(String s) {
		if(s.length() < 2) return 0;
		
		char[] ca = s.toCharArray();
		int len = ca.length;
		Stack<Integer> stack = new Stack<>();	// stack to put index of '(' or ')'
		for(int i = 0; i < len; i++) {
			char c = ca[i];
			if(c == '(') {
				stack.push(i);
			}
			else {	// c == ')'
				if(stack.isEmpty() || ca[stack.peek()] == ')') {
					stack.push(i);	// put index of ')'
				}
				else {	// is not empty and become a pair with ')'
					stack.pop();	// you can ignore this pair '()'
				}
			}
		}
		int pre = len, max = 0;
		while(!stack.isEmpty()) {	// until stack go empty
			int cur = stack.pop();	// pop index from stack
			max = Math.max(max, pre-cur-1);	// calculate the distance between cur and pre, get max
			pre = cur;	// pre of next round
		}
		max = Math.max(max, pre);
		
		return max;
    }
}
