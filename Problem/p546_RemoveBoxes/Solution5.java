// Top-down DP
package p546_RemoveBoxes;

public class Solution5 {
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
//		int[] boxes = {1,3,2,2,2,3,4,3,1};
//		int[] boxes = {1,2,1,1,3};
//		int[] boxes = {1,2,1,2,1};
//		int[] boxes = {1,2,1};
		int[] boxes = {1,2,2,1,1,1,2,1,1,2,1,2,1,1,2,2,1,1,2,2,1,1,1,2,2,2,2,1,2,1,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,1,1,1,2,2,1,2,1,2,2,1,2,1,1,1,2,2,2,2,2,1,2,2,2,2,2,1,1,1,1,1,2,2,2,2,2,1,1,1,1,2,2,1,1,1,1,1,1,1,2,1,2,2,1};
		System.out.println(sol.removeBoxes(boxes));
	}
	
	public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        int[][][] dp = new int[len][len][len];
        
        return helper(dp, boxes, 0, len-1, 0);
    }
	
	private int helper(int[][][] dp, int[] boxes, int i, int j, int k) {
		if(i > j) return 0;
		if(dp[i][j][k] > 0) return dp[i][j][k];
		
		int i0 = i, k0 = k;
		for(; i+1 <= j && boxes[i] == boxes[i+1]; i++) k++;
		int res = (k+1) * (k+1) + helper(dp, boxes, i+1, j, 0);
		for(int m = i+1; m <= j; m++) {
			if(boxes[i] == boxes[m]) {
				res = Math.max(res, helper(dp, boxes, i+1, m-1, 0)+helper(dp, boxes, m, j, k+1));
			}
		}
		
		dp[i0][j][k0] = res;
		return res;
	}
	
	// show int 2D-array
	private void show(int[][] A) {
		System.out.print("[");
		for(int i = 0; i < A.length; i++) {
			System.out.print("[");
			for(int j = 0; j < A[i].length; j++) {
				System.out.printf("%4d", A[i][j]);
				if(j != A[i].length-1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
			if(i != A.length-1) {
				System.out.print(",\n ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}