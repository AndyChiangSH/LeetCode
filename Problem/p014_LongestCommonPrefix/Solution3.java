package p014_LongestCommonPrefix;

import java.util.Arrays;

public class Solution3 {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = {"abc","ab","a"};
		System.out.println("\""+sol.longestCommonPrefix(input)+"\"");
	}
	
	public String longestCommonPrefix(String[] strs) {
		
		if(strs == null || strs.length == 0) return "";
		
        String result = "";
        Arrays.sort(strs);
        
        char [] a = strs[0].toCharArray();
        char [] b = strs[strs.length-1].toCharArray();
        
        for(int i = 0; i < a.length; i ++) {
            if (b.length > i && b[i] == a[i]) {
                result += b[i];
            }
            else {
            	break;
            }
        }
        
        return result;
	}
}
