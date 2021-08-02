package p564_FindTheClosestPalindrome;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String n = "2147483647";
		System.out.println("n = "+n);
		System.out.println("ans = "+sol.nearestPalindromic(n));
	}
	
	public String nearestPalindromic(String n) {
        if(n.length() == 0 || n == "0") return "";
        
        StringBuilder upper = new StringBuilder();
		StringBuilder center = new StringBuilder();
		StringBuilder lower = new StringBuilder();
        int len = n.length();
        int mid = (len+1)/2;
    	StringBuilder A = new StringBuilder(n.substring(0, mid));	// half of n
    	StringBuilder Aminus1 = new StringBuilder(Integer.toString(Integer.parseInt(A.toString())-1));	// A+1
    	StringBuilder Aplus1 = new StringBuilder(Integer.toString(Integer.parseInt(A.toString())+1));	// A-1
    	
//    	System.out.println("A = "+A);
//    	System.out.println("Aminus1 = "+Aminus1);
//    	System.out.println("Aplus1 = "+Aplus1);
    	
        if((len&1) == 0) {	// even length
        	// lower
        	if(is100(A)) {	// A is 100 and will borrow
        		if(Aminus1.toString().equals("0")) Aminus1.deleteCharAt(0);	// clear 0
        		lower.append(Aminus1).append('9').append(Aminus1.reverse());
        	}
        	else {
        		lower.append(Aminus1).append(Aminus1.reverse());
        	}
        	
        	// upper
        	if(is999(A)) {	// A is 999 and will carry
        		upper.append(Aplus1).append(Aplus1.reverse().subSequence(1, Aplus1.length()));
        	}
        	else {
        		upper.append(Aplus1).append(Aplus1.reverse());
        	}
        	
        	// center
        	center.append(A).append(A.reverse());
        }
        else {	// odd length
        	// lower
        	if(is100(A)) {	// A is 100 and will borrow
        		lower.append(Aminus1).append(Aminus1.reverse());
        	}
        	else {	
        		lower.append(Aminus1).append(Aminus1.reverse().substring(1, Aminus1.length()));
        	}
        	
        	// upper
        	if(is999(A)) {	// A is 999 and will carry
        		StringBuilder AplusSub = new StringBuilder(Aplus1.substring(0, Aplus1.length()-1));
        		upper.append(AplusSub).append(AplusSub.reverse());
        	}
        	else {
        		upper.append(Aplus1).append(Aplus1.reverse().substring(1, Aplus1.length()));
        	}
        	
        	// center
        	center.append(A).append(A.reverse().substring(1, A.length()));
        }
        
//        System.out.println("upper = "+upper);
//        System.out.println("center = "+center);
//        System.out.println("lower = "+lower);
        
        long upper_num = Long.parseLong(upper.toString());
        long center_num = Long.parseLong(center.toString());
        long lower_num = Long.parseLong(lower.toString());
        long n_num = Long.parseLong(n);
        
        if(n_num > center_num) {	// n_num between upper and center
        	if((n_num-center_num) <= (upper_num-n_num)) {	// close to center
        		return String.valueOf(center_num);
        	}
        	else {	// close to upper
        		return String.valueOf(upper_num);
        	}
        }
        else if(n_num < center_num) {	// n_num between center and lower
        	if((n_num-lower_num) <= (center_num-n_num)) {	// close to lower
        		return String.valueOf(lower_num);
        	}
        	else {	// close to center
        		return String.valueOf(center_num);
        	}
        }
        else {	// n_num equals to center
        	if((n_num-lower_num) <= (upper_num-n_num)) {	// close to lower
        		return String.valueOf(lower_num);
        	}
        	else {	// close to center
        		return String.valueOf(upper_num);
        	}
        }
    }
	
	private boolean is100(StringBuilder s) {
		// return true if s is 10000...
		for(int i = s.length()-1; i >= 0; i--) {
			if(i == 0 && s.charAt(i) == '1') return true;
			if(s.charAt(i) != '0') return false;
		}
		return false;
	}
	
	private boolean is999(StringBuilder s) {
		// return true if s is 9999...
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) != '9') return false;
		}
		return true;
	}
}
