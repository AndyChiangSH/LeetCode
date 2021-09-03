package p546_RemoveBoxes;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
//		int[] boxes = {1,3,2,2,2,3,4,3,1};
//		int[] boxes = {1,2,1,1,3};
		int[] boxes = {1,2,1,2,1};
		System.out.println(sol.removeBoxes(boxes));
	}
	
	public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        int[][] dp = new int[len][len];
        
        for(int i = 0; i < len; i++) {
        	dp[i][i] = 1;
        }
        for(int i = 1; i < len; i++) {
        	for(int j = 0; j < len-i; j++) {
        		dp[j][j+i] = dp[j+1][j+i] + dp[j][j+i-1] - dp[j+1][j+i-1];
        		if(boxes[j] == boxes[j+i]) dp[j][j+i] += 2;
        	}
        }
        
        show(dp);
        return dp[0][len-1];
    }
	
	// show int 2D-array
	private void show(int[][] A) {
		System.out.print("[");
		for(int i = 0; i < A.length; i++) {
			System.out.print("[");
			for(int j = 0; j < A[i].length; j++) {
				System.out.printf("%2d", A[i][j]);
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
