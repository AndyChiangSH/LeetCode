// DFS
package p200_NumberOfIslands;

public class Solution2 {
	public static void main(String[] args) {
		char[][] grid = {
	        {'1','1','1','1','0'},
	        {'1','1','0','1','0'},
	        {'1','1','0','0','0'},
	        {'0','0','0','0','0'}
	    };
//		char[][] grid = {
//	        {'1','1','0','0','0'},
//	        {'1','1','0','0','0'},
//	        {'0','0','1','0','0'},
//	        {'0','0','0','1','1'}
//	    };
		Solution2 test = new Solution2();
		int islands = test.numIslands(grid);
		System.out.println("islands = "+islands);
	}
	
	public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        if(grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        
        int islands = 0;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
            	if(grid[i][j] == '1') {
            		dfs(grid, i, j);
            		islands++;
            	}
            }
        }
        
        return islands;
    }
	
	private void dfs(char[][] grid, int x, int y) {
		if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') return;
		
		grid[x][y] = '0';
		dfs(grid, x-1, y);
		dfs(grid, x+1, y);
		dfs(grid, x, y-1);
		dfs(grid, x, y+1);
		
		return;
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
