package p17_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;

public class Solution2 {
	public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		if(digits == null || digits.length() == 0) return ans;	// return empty array
		
		recursive(ans, digits, 0, "");
		return ans;
    }
	
	private void recursive(List<String> ans, String digits, int index, String letters) {
		
		if(index == digits.length()) {
			ans.add(letters);
			return;
		}
		
		char digit = digits.charAt(index);
		String choice = DtoL(digit);
		
		
		for(int i = 0; i < choice.length(); i++) {
			recursive(ans, digits, index+1, letters+choice.charAt(i));
		}
		return;
	}
	
	private String DtoL(char digit) {
		if(digit == '2') {
			return "abc";
		}
		if(digit == '3') {
			return "def";
		}
		if(digit == '4') {
			return "ghi";
		}
		if(digit == '5') {
			return "jkl";
		}
		if(digit == '6') {
			return "mno";
		}
		if(digit == '7') {
			return "pqrs";
		}
		if(digit == '8') {
			return "tuv";
		}
		if(digit == '9') {
			return "wxyz";
		}
		return "";
	}
}
