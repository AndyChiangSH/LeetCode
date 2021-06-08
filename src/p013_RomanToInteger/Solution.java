package p013_RomanToInteger;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "MCD";
		int ans = sol.romanToInt(input);
		System.out.println(ans);
	}
	
	public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        int I = 0, V = 0, X = 0, L = 0, C = 0, D = 0, M = 0, len = roman.length;
        
        for(int i = 0; i < len; i++) {
        	char r = roman[i];
        	if(r == 'I') {
        		if(i != len-1) {
        			if(roman[i+1] == 'V' || roman[i+1] == 'X') {
        				I = -1;
        				continue;
        			}
        		}
        		I++;
        	}
        	else if(r == 'V') {
        		V++;
        	}
        	else if(r == 'X') {
        		if(i != len-1) {
        			if(roman[i+1] == 'L' || roman[i+1] == 'C') {
        				X = -1;
        				continue;
        			}
        		}
        		X++;
        	}
        	else if(r == 'L') {
        		L++;
        	}
        	else if(r == 'C') {
        		if(i != len-1) {
        			if(roman[i+1] == 'D' || roman[i+1] == 'M') {
        				C = -1;
        				continue;
        			}
        		}
        		C++;
        	}
        	else if(r == 'D') {
        		D++;
        	}
        	else if(r == 'M') {
        		M++;
        	}
        	else {
        		return -1;
        	}
        }
        
        System.out.println("I = "+I);
        System.out.println("V = "+V);
        System.out.println("X = "+X);
        System.out.println("L = "+L);
        System.out.println("C = "+C);
        System.out.println("D = "+D);
        System.out.println("M = "+M);
        
        return I*1+V*5+X*10+L*50+C*100+D*500+M*1000;
    }
}
