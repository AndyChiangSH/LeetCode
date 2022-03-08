package p407_TrappingRainWater_II;

import java.util.PriorityQueue;

public class Solution6 {
	public static void main(String[] args) {
		Solution6 test = new Solution6();
//		int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};	// 4
//		int[][] heightMap = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};	// 10
//		int[][] heightMap = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};	// 0
		int[][] heightMap = {{11,21,31},{81,9,41},{17,61,51}};	// 12
//		int[][] heightMap = {{9,9,9,9,9,9,8,9,9,9,9},{9,0,0,0,0,0,1,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,9,9,9}};	// 215
		
		System.out.println("Init:");
        test.show(heightMap);
        
		int answer = test.trapRainWater(heightMap);
		System.out.println("answer = "+answer);
	}
	
	public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> heightMap[a[0]][a[1]]-heightMap[b[0]][b[1]]);
        
        for(int i = 0; i < m; i++) {
    		visited[i][0] = true;
    		visited[i][n-1] = true;
    		queue.add(new int[] {i, 0});
    		queue.add(new int[] {i, n-1});
        }
        for(int i = 1; i < n-1; i++) {
    		visited[0][i] = true;
    		visited[m-1][i] = true;
    		queue.add(new int[] {0, i});
    		queue.add(new int[] {m-1, i});
        }
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int water = 0;
        while(!queue.isEmpty()) {
        	int[] cell = queue.poll();
        	for(int i = 0; i < 4; i++) {
        		int row = cell[0] + dirs[i][0];
        		int col = cell[1] + dirs[i][1];
        		if(row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
        			visited[row][col] = true;
        			water += Math.max(0, heightMap[cell[0]][cell[1]]-heightMap[row][col]);
        			queue.add(new int[] {row, col});
        			heightMap[row][col] = Math.max(heightMap[cell[0]][cell[1]], heightMap[row][col]);
        		}
        	}
        }
        
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
	}
}
