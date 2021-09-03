// Bottom-up DP
package p546_RemoveBoxes;

public class Solution4 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		int[] boxes = {1,3,2,2,2,3,4,3,1};
//		int[] boxes = {1,2,1,1,3};
//		int[] boxes = {1,2,1,2,1};
//		int[] boxes = {1,2,1};
//		int[] boxes = {1,2,2,1,1,1,2,1,1,2,1,2,1,1,2,2,1,1,2,2,1,1,1,2,2,2,2,1,2,1,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,1,1,1,2,2,1,2,1,2,2,1,2,1,1,1,2,2,2,2,2,1,2,2,2,2,2,1,1,1,1,1,2,2,2,2,2,1,1,1,1,2,2,1,1,1,1,1,1,1,2,1,2,2,1};
		System.out.println(sol.removeBoxes(boxes));
	}
	
	public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        int[][][] dp = new int[len][len][len];
        
        for(int i = 0; i < len; i++) {
        	for(int k = 0; k < len; k++) {
        		dp[i][i][k] = (k+1)*(k+1);
        	}
        }
        for (int l = 1; l < len; l++) {
        	for (int i = 0; i < len-l; i++) {
        	    int j = i+l;
        	        
        	    for (int k = 0; k <= i; k++) {
        	        int res = (k+1) * (k+1) + dp[i+1][j][0];
        	            
        	        for (int m = i+1; m <= j; m++) {
        	            if (boxes[m] == boxes[i]) {
        	            	if(dp[i+1][m-1][0] + dp[m][j][k+1] > res) {
        	            		res = dp[i+1][m-1][0] + dp[m][j][k+1];
        	            	}
        	            }
        	        }
        	            
        	        dp[i][j][k] = res;
//        	    	System.out.println("["+i+", "+j+", "+k+"]");
        	    }
        	}
        }
        
        return dp[0][len-1][0];
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