package c20210628_RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String str = "";
		System.out.println(sol.removeDuplicates(str));
	}
	
	public String removeDuplicates(String s) {
        if(s == null || s == "") return "";
        
		char[] ca = s.toCharArray();
		int len = ca.length, top = 0;
		char[] st = new char[len];
		
		for(int i = 0; i < len; i++) {
			char ch = ca[i];
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
