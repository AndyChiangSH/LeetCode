// Solution1: up one level at a time
package p407_TrappingRainWater_II;

public class Solution {
	public static void main(String[] args) {
		Solution test = new Solution();
//		int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
//		int[][] heightMap = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};
//		int[][] heightMap = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
		int[][] heightMap = {{11,21,31},{81,9,41},{17,61,51}};
		int answer = test.trapRainWater(heightMap);
		System.out.println("answer = "+answer);
	}
	
	int[][] height_map;
	int m;
	int n;
	boolean is_trap = true;
	int water = 0;
	int total_water = 0;
	
	public int trapRainWater(int[][] heightMap) {
		height_map = heightMap;
        if(height_map.length <= 2 || height_map[0].length <= 2) return 0;
        m = height_map.length;
        n = height_map[0].length;
        
        // find max and min height
        int h_max = height_map[0][0], h_min = height_map[0][0];
        for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(height_map[i][j] > h_max) {
    				h_max = height_map[i][j];
    			}
    			if(height_map[i][j] < h_min) {
    				h_min = height_map[i][j];
    			}
    		}
        }
        
        for(int h = h_min; h <= h_max; h++) {
        	for(int i = 1; i < m-1; i++) {
        		for(int j = 1; j < n-1; j++) {
            		if(height_map[i][j] == h) {	// on this height
            			is_trap = true;
            			water = 0;
            			dfs(i, j, h);	// DFS
            			if(is_trap) {
//            				System.out.println("h="+h+", i="+i+", j="+j+", water="+water);
            				total_water += water;
            			}
            		}
            	}
        	}
//        	System.out.println("h="+h+", total_water="+total_water);
//        	show(height_map);
        }
        
        return total_water;
    }
	
	private void dfs(int i, int j, int h) {		
		if(height_map[i][j] > h) return;
		
		height_map[i][j] = h+1;
		if(i <= 0 || i >= m-1 || j <= 0 || j >= n-1) {	// in boundary
			is_trap = false;
		}
		else {
			water++;
			// search up, down, left and right
			dfs(i-1, j, h);
			dfs(i+1, j, h);
			dfs(i, j-1, h);
			dfs(i, j+1, h);
		}
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
	}
}
