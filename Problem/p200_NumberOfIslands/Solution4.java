// Union-Find
package p200_NumberOfIslands;

public class Solution4 {
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
		Solution4 test = new Solution4();
		int islands = test.numIslands(grid);
		System.out.println("islands = "+islands);
	}
	
	int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
	
    public int numIslands(char[][] grid) {  
        if (grid == null || grid.length == 0 || grid[0].length == 0)  {
            return 0;  
        }
        UnionFind uf = new UnionFind(grid);  
        int rows = grid.length;  
        int cols = grid[0].length;  
        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {  
                if (grid[i][j] == '1') {  
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {  
                            int id1 = i*cols+j;
                            int id2 = x*cols+y;
                            uf.union(id1, id2);  
                        }  
                    }  
                }  
            }  
        }  
        return uf.count;  
    }
	
    class UnionFind {
        int[] father;  
        int m, n;
        int count = 0;
        
        UnionFind(char[][] grid) {  
            m = grid.length;  
            n = grid[0].length;  
            father = new int[m*n];  
            for (int i = 0; i < m; i++) {  
                for (int j = 0; j < n; j++) {  
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        father[id] = id;
                        count++;
                    }
                }  
            }  
        }
        
        public void union(int node1, int node2) {  
            int find1 = find(node1);
            int find2 = find(node2);
            if(find1 != find2) {
                father[find1] = find2;
                count--;
            }
        }
        
        public int find (int node) {  
            if (father[node] == node) {  
                return node;
            }
            father[node] = find(father[node]);  
            return father[node];
        }
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
