package p013_RomanToInteger;

public class Solution3 {
	
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String input = "MCD";
		int ans = sol.romanToInt(input);
		System.out.println(ans);
	}
	
	public int romanToInt(String s) {
		char[] roman = s.toCharArray();
		int sum = 0, len = roman.length;
		char prev = ' ';
		
		for(byte i = 0; i < len; i++) {
			char r = roman[i];
			sum += getValue(r, prev);
			prev = r;
		}
		
		return sum;
    }
	
	private int getValue(char c, char prev) {
		if(c == 'I') return 1;
		if(c == 'V') return prev == 'I' ? 3 : 5;
		if(c == 'X') return prev == 'I' ? 8 : 10;
		if(c == 'L') return prev == 'X' ? 30 : 50;
		if(c == 'C') return prev == 'X' ? 80 : 100;
		if(c == 'D') return prev == 'C' ? 300 : 500;
		if(c == 'M') return prev == 'C' ? 800 : 1000;
		return 0;
	}
}
