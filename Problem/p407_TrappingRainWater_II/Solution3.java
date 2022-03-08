// Solution3: BFS by min-heap (failed)
package p407_TrappingRainWater_II;

import java.util.PriorityQueue;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 test = new Solution3();
//		int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};	// 4
//		int[][] heightMap = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};	// 10
//		int[][] heightMap = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};	// 0
//		int[][] heightMap = {{11,21,31},{81,9,41},{17,61,51}};	// 12
		int[][] heightMap = {{9,9,9,9,9,9,8,9,9,9,9},{9,0,0,0,0,0,1,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,9,9,9}};
		
		int answer = test.trapRainWater(heightMap);
		System.out.println("answer = "+answer);
	}
	
	class Cell implements Comparable<Cell> {
        public int row, col, height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        public int compareTo(Cell o) {
            return this.height - o.height;
        }
    }
	
	int[][] height_map;
	int m;
	int n;
	boolean is_trap = true;
	int water = 0;
	int total_water = 0;
	int border_min = 0;
	
	public int trapRainWater(int[][] heightMap) {
		height_map = heightMap;
        if(height_map.length <= 2 || height_map[0].length <= 2) return 0;
        m = height_map.length;
        n = height_map[0].length;
        
        System.out.println("Init:");
        show(height_map);
        
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
        
        for(int i = 1; i < m-1; i++) {
    		for(int j = 1; j < n-1; j++) {
    			queue.add(new Cell(i, j, height_map[i][j]));
    		}
        }
        
        while(!queue.isEmpty()) {
        	Cell cell = queue.poll();
        	System.out.println("row="+cell.row+", col="+cell.col+", height="+cell.height);
        	if(height_map[cell.row][cell.col] > cell.height) {
        		continue;
        	}
        	
        	
        	is_trap = true;
        	water = 0;
        	border_min = 99999;
        	dfs1(cell.row, cell.col, cell.height);
        	System.out.println("border_min="+border_min);
        	dfs2(cell.row, cell.col, cell.height);
        	if(is_trap) {
        		total_water += water;
        		queue.add(new Cell(cell.row, cell.col, border_min));
        	}
        	
        	System.out.println("total_water="+total_water);
        	show(height_map);
        }
        
        return total_water;
    }
	
	private void dfs1(int i, int j, int h) {
		if(height_map[i][j] == -h) {
			return;
		}
		if(height_map[i][j] > h) {
			if(height_map[i][j] < border_min) {
				border_min = height_map[i][j];
			}
			return;
		}
		
		height_map[i][j] = -h;
		if(i <= 0 || i >= m-1 || j <= 0 || j >= n-1) {
			is_trap = false;
		}
		else {
			dfs1(i-1, j, h);
			dfs1(i+1, j, h);
			dfs1(i, j-1, h);
			dfs1(i, j+1, h);
		}
	}
	
	private void dfs2(int i, int j, int h) {		
		if(height_map[i][j] != -h) return;
		
		height_map[i][j] = border_min;
		if(i <= 0 || i >= m-1 || j <= 0 || j >= n-1) {
		}
		else {
			water += (border_min-h);
			dfs2(i-1, j, h);
			dfs2(i+1, j, h);
			dfs2(i, j-1, h);
			dfs2(i, j+1, h);
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
