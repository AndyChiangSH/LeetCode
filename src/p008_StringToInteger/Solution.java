package p008_StringToInteger;

public class Solution {
	public static void main(String[] args) {
		Solution test = new Solution();
		String str = "3.14159";
		System.out.println(test.myAtoi(str));
	}
	
    public int myAtoi(String s) {
        
    	boolean isPos = true;
    	int index = 0;
    		
    	while(index < s.length()) {		// remove extra whitespace
    		if(s.charAt(index) != ' ') 
    			break;
    		index++;
    	}
    	
    	if(index == s.length())		// condition that str is all whitespace
    		return 0;
    	
    	if(s.charAt(index) == '-') {	// negative sign
    		isPos = false;
    		index++;
    	}
    	else if(s.charAt(index) == '+') {	// positive sign
    		index++;
    	}
    	else if(s.charAt(index)<= 57 && s.charAt(index) >= 48) {}	// digit
    	else	// other word
    		return 0;
    		
    	int integer = 0;
    	while(index < s.length()) {
    		if(!(s.charAt(index)<= 57 && s.charAt(index) >= 48)) 	// is not digit
    			break;
    		
    		int dig = (int)(s.charAt(index)-'0');
    		if(integer > Integer.MAX_VALUE/10) {	// integer is larger than MAX_VALUE/10
    			if(isPos) {
    				return Integer.MAX_VALUE;
    			}
    			else {
    				return Integer.MIN_VALUE;
    			}
    		}
    		else if(integer == Integer.MAX_VALUE/10) {	// integer is equal to MAX_VALUE/10
    			if(isPos) {
    				if(dig > 7) {		// positive
    					return Integer.MAX_VALUE;
    				}
    			}
    			else {
    				if(dig > 8) {		// negative
    					return Integer.MIN_VALUE;
    				}
    			}
    		}
    		
    		integer = integer*10 + dig;
    		index++;
    	}
    	
    	if(!isPos)
    		integer = -integer;
    	
    	return integer;
    }	
}
