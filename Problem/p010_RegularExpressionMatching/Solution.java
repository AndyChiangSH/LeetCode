package p010_RegularExpressionMatching;

public class Solution {
	
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = "mississippi";
		String p = "mis*is*p*.";
		
		boolean ans = test.isMatch(s, p);
		System.out.println(ans);
	}
	
    public boolean isMatch(String s, String p) {
        
    	int i = 0, j = 0;
    	while(i < s.length() && j < p.length()) {	// 如果s或p都跑完了，則結束迴圈
    		System.out.println("i = "+i+", j = "+j);
    		char s_char = s.charAt(i);	// s讀到的字元
    		if(s_char == p.charAt(j)) {	// s和p的字元相同的情況
    			if(j != p.length()-1) {
    				if(p.charAt(j+1) == '*') {	// p的下一個是不是星星
    					i++;
    					while(s.charAt(i) == s_char && i+1 < s.length()) {
    						i++;
    					}
    					j += 2;
    					continue;
    				}
    			}
				i++;
				j++;
    		}
    		else if(p.charAt(j) == '.') {	// p的字元是"."
    			if(j != p.length()-1) {
    				if(p.charAt(j+1) == '*') {	// p的下一個是不是星星
    					continue;
    				}
    			}
				i++;
				j++;
    		}
    		else {	// 不相同也不是"."
    			System.out.println("1");
    			if(j != p.length()-1) {
    				if(p.charAt(j+1) == '*') {	// p的下一個是不是星星
    					j += 2;
    					continue;
    				}
    				System.out.println("j: "+p.charAt(j)+", j+1: "+p.charAt(j+1));
    				System.out.println("3");
    			}
    			
    			System.out.println("4");
    			return false;
    		}
    	}
    	
    	System.out.println("i="+i+", j="+j);
    	if(i < s.length()-1 || j < p.length()-1) {	// 如果p或s其中一個還沒結束
    		System.out.println("2");
    		return false;
    	}
    	return true;
    }
}
