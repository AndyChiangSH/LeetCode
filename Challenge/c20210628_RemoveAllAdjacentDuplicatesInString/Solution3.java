package c20210628_RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

public class Solution3 {
	
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String str = "";
		System.out.println(sol.removeDuplicates(str));
	}
	
	public String removeDuplicates(String s) {
        if(s == null || s == "") return "";
        
		int len = s.length(), top = 0;
		char[] st = new char[len];
		
		for(int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if(top > 0 && st[top-1] == ch) {
				top--;
			}
			else {
				st[top++] = ch;
			}
		}
		
		return new String(st, 0, top);
    }
}
