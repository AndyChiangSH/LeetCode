package testing;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String str = "bca";
		char[] ca = str.toCharArray();
		Arrays.sort(ca);
		System.out.println(new String(ca));
	}
}
