package p050_Pow_x_n;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		double x = -1.00000;
		int n = 2147483646;
		System.out.printf("%.5f", sol.myPow(x, n));
	}
	
	public double myPow(double x, int n) {
		if(x == 0) return 0;
		if(x == 1) return 1;
		if(x == -1) {
			if(n%2 == 0) return 1;
			else return -1;
		}
		
		double answer = 1.0;
        int realN = n;
        long N = (long) n;

		if(n < 0) {
			N = -1 * N;
		}
		while(N > 0) {
			if(N % 2 == 0) {
				x = x * x;	// x*x if N is even
				N /= 2;
			}
			else {
				answer = x * answer;	// x*answer if N is odd
				N -= 1;
			}
		}
        
        return realN >= 0 ? answer : 1/answer;
    }
}
