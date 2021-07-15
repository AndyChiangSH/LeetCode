package testing;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		String str = "bacee";
		System.out.println(test.hash(str));
	}
	
	private String hash(String s){
        int[] a = new int[26];
        for(char c : s.toCharArray()) a[c-'a']++;
        return Arrays.toString(a);
    }
}
