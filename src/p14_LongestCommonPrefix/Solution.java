package p14_LongestCommonPrefix;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = {"abc","ab",""};
		System.out.println("\""+sol.longestCommonPrefix(input)+"\"");
	}
	
	public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        boolean isEnd = false;
		int len = strs.length;
        String lcp = "";
        
        for(int i = 0; i < strs[0].length(); i++) {
        	char ch = strs[0].charAt(i);
        	for(int j = 1; j < len; j++) {
        		if(strs[j].length() == i || strs[j].charAt(i) != ch) {
        			isEnd = true;
        			break;
        		}        		
        	}
        	if(isEnd) {
        		break;
        	}
        	else {
        		lcp = lcp+ch;
        	}
        }
        
        return lcp;
    }
}
