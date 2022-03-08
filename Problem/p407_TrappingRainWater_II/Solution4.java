// Solution4: BFS from boundary
package p407_TrappingRainWater_II;

import java.util.PriorityQueue;

public class Solution4 {
	public static void main(String[] args) {
		Solution4 test = new Solution4();
//		int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};	// 4
//		int[][] heightMap = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};	// 10
//		int[][] heightMap = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};	// 0
		int[][] heightMap = {{11,21,31},{81,9,41},{17,61,51}};	// 12
//		int[][] heightMap = {{9,9,9,9,9,9,8,9,9,9,9},{9,0,0,0,0,0,1,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,9,9,9}};
		
		System.out.println("Init:");
        test.show(heightMap);
        
		int answer = test.trapRainWater(heightMap);
		System.out.println("answer = "+answer);
	}
	
	// element of min-heap
	class Cell implements Comparable<Cell> {
        public int row, col, height;

        public Cell(int height, int row, int col) {
        	this.height = height;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Cell o) {	// order by height
            return this.height - o.height;
        }
    }
	
	public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
        
        // add all boundary into min-heap
        for(int i = 0; i < m; i++) {
    		visited[i][0] = true;
    		visited[i][n-1] = true;
    		queue.add(new Cell(heightMap[i][0], i, 0));
    		queue.add(new Cell(heightMap[i][n-1], i, n-1));
        }
        for(int i = 1; i < n-1; i++) {
    		visited[0][i] = true;
    		visited[m-1][i] = true;
    		queue.add(new Cell(heightMap[0][i], 0, i));
    		queue.add(new Cell(heightMap[m-1][i], m-1, i));
        }
        
        // BFS from boundary
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int water = 0;
        while(!queue.isEmpty()) {
        	Cell cell = queue.poll();
        	for(int i = 0; i < 4; i++) {
        		int row = cell.row + dirs[i][0];
        		int col = cell.col + dirs[i][1];
        		if(row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
        			visited[row][col] = true;
        			water += Math.max(0, cell.height-heightMap[row][col]);
        			queue.add(new Cell(Math.max(cell.height, heightMap[row][col]), row, col));
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
