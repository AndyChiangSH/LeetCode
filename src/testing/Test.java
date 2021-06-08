package testing;

public class Test {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 5) {
					break;
				}
				System.out.println("i = "+i+", j = "+j);
			}
		}
	}
}
