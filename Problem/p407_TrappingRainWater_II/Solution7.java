// Solution7: DP
package p407_TrappingRainWater_II;

public class Solution7 {
	public static void main(String[] args) {
		Solution7 test = new Solution7();
//		int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};	// 4
//		int[][] heightMap = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};	// 10
//		int[][] heightMap = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};	// 0
//		int[][] heightMap = {{11,21,31},{81,9,41},{17,61,51}};	// 12
//		int[][] heightMap = {{9,9,9,9,9,9,8,9,9,9,9},{9,0,0,0,0,0,1,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,9,9,9}};	// 215
		int[][] heightMap = {{13,16,15,18,15,15},{14,1,8,9,7,9},{19,5,4,2,5,10},{13,1,7,9,10,3},{17,7,5,10,6,1},{15,9,8,2,8,3}};
		
		System.out.println("Init:");
        test.show(heightMap);
        
		int answer = test.trapRainWater(heightMap);
		System.out.println("answer = "+answer);
	}
	
	public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        int water = 0;
        int[][] dp = new int[m][n];
        
        // right
        for(int i = 0; i < m; i++) {
        	int temp_max = 0;
        	for(int j = 0; j < n; j++) {
            	if(heightMap[i][j] > temp_max) {
            		temp_max = heightMap[i][j];
            	}
            	dp[i][j] = temp_max;
            }
        }
        // left
        for(int i = 0; i < m; i++) {
        	int temp_max = 0;
        	for(int j = n-1; j >= 0; j--) {
            	if(heightMap[i][j] > temp_max) {
            		temp_max = heightMap[i][j];
            	}
            	if(temp_max > dp[i][j]) {
            		temp_max = dp[i][j];
            	}
            	dp[i][j] = temp_max;
            }
        }
        // down
        for(int j = 0; j < n; j++) {
        	int temp_max = 0;
        	for(int i = 0; i < m; i++) {
            	if(heightMap[i][j] > temp_max) {
            		temp_max = heightMap[i][j];
            	}
            	if(temp_max > dp[i][j]) {
            		temp_max = dp[i][j];
            	}
            	dp[i][j] = temp_max;
            }
        }
        // up
        for(int j = 0; j < n; j++) {
        	int temp_max = 0;
        	for(int i = m-1; i >= 0; i--) {
            	if(heightMap[i][j] > temp_max) {
            		temp_max = heightMap[i][j];
            	}
            	if(temp_max > dp[i][j]) {
            		temp_max = dp[i][j];
            	}
            	dp[i][j] = temp_max;
            }
        }

        // right
        for(int i = 0; i < m; i++) {
        	int temp_max = 0;
        	for(int j = 0; j < n; j++) {
        		if(heightMap[i][j] > temp_max) {
            		temp_max = heightMap[i][j];
            	}
            	if(temp_max > dp[i][j]) {
            		temp_max = dp[i][j];
            	}
            	dp[i][j] = temp_max;
            }
        }
        // left
        for(int i = 0; i < m; i++) {
        	int temp_max = 0;
        	for(int j = n-1; j >= 0; j--) {
            	if(heightMap[i][j] > temp_max) {
            		temp_max = heightMap[i][j];
            	}
            	if(temp_max > dp[i][j]) {
            		temp_max = dp[i][j];
            	}
            	dp[i][j] = temp_max;
            }
        }
        // up
        for(int j = 0; j < n; j++) {
        	int temp_max = 0;
        	for(int i = m-1; i >= 0; i--) {
            	if(heightMap[i][j] > temp_max) {
            		temp_max = heightMap[i][j];
            	}
            	if(temp_max > dp[i][j]) {
            		temp_max = dp[i][j];
            	}
            	dp[i][j] = temp_max;
            }
        }
        // down
        for(int j = 0; j < n; j++) {
        	int temp_max = 0;
        	for(int i = 0; i < m; i++) {
            	if(heightMap[i][j] > temp_max) {
            		temp_max = heightMap[i][j];
            	}
            	if(temp_max > dp[i][j]) {
            		temp_max = dp[i][j];
            	}
            	dp[i][j] = temp_max;
            }
        }
        
        // count
        for(int i = 1; i < m-1; i++) {
        	for(int j = 1; j < n-1; j++) {
            	water += Math.max(0, dp[i][j]-heightMap[i][j]);
            }
        }
        
        show(heightMap);
        show(dp);
        
        return water;
    }
	
	// show int 2D-array
	private void show(int[][] A) {
		System.out.print("[");
		for(int i = 0; i < A.length; i++) {
			System.out.print("[");
			for(int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j]);
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
		System.out.println();
	}
}
