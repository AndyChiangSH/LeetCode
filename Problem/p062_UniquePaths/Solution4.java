package p062_UniquePaths;

public class Solution4 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		int m = 7;
		int n = 3;
		System.out.println(sol.uniquePaths(m, n));
	}
	
	public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for(int i = 1; i < m+1; i++) {
        	for(int j = 1; j < n+1; j++) {
        		dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
        
        return dp[m][n];
    }
}
