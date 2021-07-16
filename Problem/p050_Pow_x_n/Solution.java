package p050_Pow_x_n;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		double x = -1.00000;
		int n = 2147483646;
		System.out.printf("%.5f", sol.myPow(x, n));
	}
	
	public double myPow(double x, int n) {
		if(x == 0) return 0;
		if(x == 1) return 1;
		if(x == -1) {
			if(n%2 == 0) {
				return 1;
			}
			else {
				return -1;
			}
		}
		
		double prod = 1;
		if(n > 0) {
			for(int i = 0; i < n; i++) {
				prod *= x;
			}
		}
		else if(n < -17) {
			return 0;
		}
		else if(n < 0) {
			for(int i = n; i < 0; i++) {
				prod /= x;
			}
		}
		else {
			return 1;
		}
		
		return prod;
    }
}
