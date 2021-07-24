package p062_UniquePaths;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int m = 10;
		int n = 10;
		System.out.println(sol.uniquePaths(m, n));
	}
	
	public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        int down = m-1, right = n-1;
        
        System.out.println("down = "+down+", right = "+right);
        System.out.println(factorial(down+right));
        
        return factorial(down+right) / (factorial(down) * factorial(right));
    }
	
	private int factorial(int n) {
		int f = 1;
		for(int i = 1; i <= n; i++) {
			f *= i;
		}
		return f;
	}
}
