package p062_UniquePaths;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int m = 20;
		int n = 20;
		System.out.println(sol.uniquePaths(m, n));
	}
	
	public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        
        int down = m-1, right = n-1;
        long denor = 1, numer = 1;
        for(int i = Math.max(down, right) + 1; i <= (down+right); i++) {
        	denor *= i;
        }
        for(int i = 1; i <= Math.min(down, right); i++) {
			numer *= i;
		}
//        System.out.println("denor = "+denor);
//        System.out.println("numer = "+numer);
        
        return (int) (denor/numer);
    }
}
