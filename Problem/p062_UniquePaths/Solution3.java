package p062_UniquePaths;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int m = 3;
		int n = 3;
		System.out.println(sol.uniquePaths(m, n));
	}
	
	public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        
        int[][] dp = new int[m][n];
        for(int i = 1; i < m; i++) dp[i][0] = 1;	// all in top line is 1
        for(int i = 1; i < n; i++) dp[0][i] = 1;	// all in left line is 1
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		dp[i][j] = dp[i-1][j] + dp[i][j-1];	// top path count + left path count
        	}
        }
        
        return dp[m-1][n-1];	// all path count
    }
}
