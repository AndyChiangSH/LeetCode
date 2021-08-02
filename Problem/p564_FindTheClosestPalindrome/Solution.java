package p564_FindTheClosestPalindrome;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String n = "12034";
		
		System.out.println("ans = "+sol.nearestPalindromic(n));
	}
	
	public String nearestPalindromic(String n) {
        if(n.length() == 0 || n == "0") return "";
        
		StringBuilder ans1 = new StringBuilder();
		StringBuilder ans2 = new StringBuilder();
        int len = n.length();
        
        System.out.println("n = "+n);
        
        if((len&1) == 0) {	// even
        	int mid = len/2;
        	StringBuilder A = new StringBuilder(n.substring(0, mid));
        	StringBuilder B = new StringBuilder(n.substring(mid));
        	
        	System.out.println("A = "+A);
        	System.out.println("B = "+B);
        	
        	String a = Integer.toString(Integer.parseInt(A.toString())-1);
        	if(a.equals("0")) {
        		a = "";
        	}
        	StringBuilder Aminus1 = new StringBuilder(a);
    		ans2.append(Aminus1);
        	if(isPower10(A)) {
        		ans2.append('9');
        	}
        	ans2.append(Aminus1.reverse());
        	ans1.append(A).append(A.reverse());
        }
        else {	// odd
        	int mid = len/2;
        	StringBuilder A = new StringBuilder(n.substring(0, mid));
        	char B = n.charAt(mid);
        	StringBuilder C = new StringBuilder(n.substring(mid+1));
        	
        	System.out.println("A = "+A);
        	System.out.println("B = "+B);
        	System.out.println("C = "+C);
        	
        	if(B == '0') {	// B == 0
        		StringBuilder AB = new StringBuilder();
        		AB.append(A).append(B);
        		StringBuilder ABminus1 = new StringBuilder(Integer.toString(Integer.parseInt(AB.toString())-1));
        		ans1.append(A).append(B).append(A.reverse());
        		ans2.append(ABminus1).append(ABminus1.reverse());
        	}
        	else {	// B != 0
        		ans1.append(A).append(B);
        		ans2.append(A).append((char) (B-1));
        		ans1.append(A.reverse());
        		ans2.append(A);
        	}
        }
        
        System.out.println("ans1 = "+ans1);
        System.out.println("ans2 = "+ans2);
        
        String s1 = ans1.toString();
        String s2 = ans2.toString();
        
        if(Integer.parseInt(s1) < Integer.parseInt(n)) {
        	return s1;
        }
        return s2;
    }
	
	private boolean isPower10(StringBuilder s) {
		for(int i = s.length()-1; i >= 0; i--) {
			if(i == 0 && s.charAt(i) == '1') return true;
			if(s.charAt(i) != '0') return false;
		}
		
		return false;
	}
}
