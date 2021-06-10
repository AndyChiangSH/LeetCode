// solution3: StringBuilder is god!!!!!!!!!!!!!!!!!!!!
package p017_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Solution3 {
	public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		if(digits == null || digits.length() == 0) return ans;
		
		StringBuilder newDigits = new StringBuilder(digits);
		StringBuilder newLetters = new StringBuilder();
		recursive(ans, newDigits, 0, newLetters, digits.length());
		return ans;
    }
	
	private void recursive(List<String> ans, StringBuilder digits, int index, StringBuilder letters, int limit) {
		if(index == limit) {
			ans.add(letters.toString());
			return;
		}
		
		char digit = digits.charAt(index);
		String choice = DtoL(digit);
		for(int i = 0; i < choice.length(); i++) {
			StringBuilder newLetters = new StringBuilder(letters);
			newLetters.append(choice.charAt(i));
			recursive(ans, digits, index+1, newLetters, limit);
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
