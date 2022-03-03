// DFS
package p200_NumberOfIslands;

public class Solution3 {
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
		Solution3 test = new Solution3();
		int islands = test.numIslands(grid);
		System.out.println("islands = "+islands);
	}
	
	char[][] grid;
    int m, n;
	
	public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        if(grid[0].length == 0) return 0;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        int islands = 0;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
            	if(grid[i][j] == '1') {
            		dfs(i, j);
            		islands++;
            	}
            }
        }
        
        return islands;
    }
	
	private void dfs(int i, int j){
		grid[i][j] = '0';
        if (i+1 < m && grid[i+1][j]=='1') dfs(i+1,j);
        if (i-1 >= 0 && grid[i-1][j]=='1') dfs(i-1,j);
        if (j+1 < n && grid[i][j+1]=='1') dfs(i,j+1);
        if (j-1 >= 0 && grid[i][j-1]=='1') dfs(i,j-1);
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
