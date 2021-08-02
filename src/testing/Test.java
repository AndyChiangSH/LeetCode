package testing;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		StringBuilder sb = new StringBuilder("999999");
		System.out.println(test.is999(sb));
		
//		String s = "hello world";
//		StringBuilder sb = new StringBuilder(s);
//		System.out.println(sb.reverse());
		
//		char n = '1';
//		char m = (char) (n-1);
//		System.out.println(m);
		
//		System.out.println(Integer.toString(Integer.parseInt("1")-1));
	}
	
	private boolean isPower10(StringBuilder s) {
		for(int i = s.length()-1; i >= 0; i--) {
			if(i == 0 && s.charAt(i) == '1') return true;
			if(s.charAt(i) != '0') return false;
		}
		
		return false;
	}
	
	private boolean is999(StringBuilder s) {
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) != '9') return false;
		}
		
		return true;
	}
}
