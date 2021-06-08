package p014_LongestCommonPrefix;

import java.util.Arrays;

public class Solution4 {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = {"abc","ab","a"};
		System.out.println("\""+sol.longestCommonPrefix(input)+"\"");
	}
	
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        Arrays.sort(strs);	// sort strings
        
        // only have to compare the first and the last string
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length())	// and find the last prefix index not match
        {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);	// slice substring
    }
}
