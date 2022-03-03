// BFS
package p200_NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
//		char[][] grid = {
//	        {'1','1','1','1','0'},
//	        {'1','1','0','1','0'},
//	        {'1','1','0','0','0'},
//	        {'0','0','0','0','0'}
//	    };
		char[][] grid = {
	        {'1','1','0','0','0'},
	        {'1','1','0','0','0'},
	        {'0','0','1','0','0'},
	        {'0','0','0','1','1'}
	    };
		Solution test = new Solution();
		int islands = test.numIslands(grid);
		System.out.println("islands = "+islands);
	}
	
	public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        if(grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        
//        show(grid);
        
        Queue<Integer> queue = new LinkedList<>();
        int islands = 0;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
            	if(grid[i][j] == '1') {
            		grid[i][j] = '0';
            		queue.add(i*n+j);
            		while(!queue.isEmpty()) {
            			int bottom = queue.remove();
            			int x = bottom/n;
            			int y = bottom%n;
            			if(x != 0 && grid[x-1][y] == '1') {	// up
            				grid[x-1][y] = '0';
            				queue.add((x-1)*n+y);
            			}
            			if(x != m-1 && grid[x+1][y] == '1') {	// down
            				grid[x+1][y] = '0';
            				queue.add((x+1)*n+y);
            			}
            			if(y != 0 && grid[x][y-1] == '1') {	// left
            				grid[x][y-1] = '0';
            				queue.add(x*n+(y-1));
            			}
            			if(y != n-1 && grid[x][y+1] == '1') {	// right
            				grid[x][y+1] = '0';
            				queue.add(x*n+(y+1));
            			}
            		}
            		islands++;
            		
//            		System.out.println("i="+i+", j="+j);
//            		show(grid);
            	}
            }
        }
        
        return islands;
    }
	
	// show int 2D-array
		private void show(char[][] A) {
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
