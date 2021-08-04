package p079_WordSearch;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "EEA";
		
		sol.show(board);
		System.out.println(sol.exist(board, word));
	}
	
	public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        boolean mark[][] = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
            	if(board[i][j] == word.charAt(0)) {
            		mark[i][j] = true;
            		if(dfs(board, mark, word, i, j, 1)) return true;
            		mark[i][j] = false;
            	}
            }
        }
        
        return false;
    }
	
	private boolean dfs(char[][] board, boolean mark[][], String word, int x, int y, int n) {
		if(n == word.length()) return true;
		
		System.out.println("board = "+board[x][y]+", word = "+word.charAt(n)+", x = "+x+", y = "+y+", n = "+n);
		
		char next_char = word.charAt(n);
		mark[x][y] = true;
		// up
		if(x != 0 && !mark[x-1][y] && board[x-1][y] == next_char) {
    		if(dfs(board, mark, word, x-1, y, n+1)) return true;
		}
		// down
		if(x != board.length-1 && !mark[x+1][y] && board[x+1][y] == next_char) {
    		if(dfs(board, mark, word, x+1, y, n+1)) return true;
		}
		// left
		if(y != 0 && !mark[x][y-1] && board[x][y-1] == next_char) {
    		if(dfs(board, mark, word, x, y-1, n+1)) return true;
		}
		// right
		if(y != board[0].length-1 && !mark[x][y+1] && board[x][y+1] == next_char) {
    		if(dfs(board, mark, word, x, y+1, n+1)) return true;
		}
		mark[x][y] = false;
		
		return false;
	}
	
	// show char 2D-array
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
