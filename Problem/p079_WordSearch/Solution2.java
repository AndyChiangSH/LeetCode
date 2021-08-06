package p079_WordSearch;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
//		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		char[][] board = {{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','B'}};
		String word = "AB";
		
		sol.show(board);
		System.out.println(sol.exist(board, word));
		sol.show(board);
	}
	
	public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        
        // test each element in board
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
            	if(board[i][j] == word.charAt(0)) {		// if first char is match, then check next char
            		if(dfs(board, word, i, j, 1)) return true;
            	}
            }
        }
        
        return false;	// no any path is match
    }
	
	private boolean dfs(char[][] board, String word, int x, int y, int n) {
		if(n == word.length()) return true;	// find word
		
		System.out.println("board = "+board[x][y]+", word = "+word.charAt(n)+", x = "+x+", y = "+y+", n = "+n);
		
		char next_char = word.charAt(n);
		char temp = board[x][y];	// to store original value
		board[x][y] = '*';	// visit -> mark '*'
		// up
		if(x != 0 && board[x-1][y] == next_char) {
    		if(dfs(board, word, x-1, y, n+1)) return true;
		}
		// down
		if(x != board.length-1 && board[x+1][y] == next_char) {
    		if(dfs(board, word, x+1, y, n+1)) return true;
		}
		// left
		if(y != 0 && board[x][y-1] == next_char) {
    		if(dfs(board, word, x, y-1, n+1)) return true;
		}
		// right
		if(y != board[0].length-1 && board[x][y+1] == next_char) {
    		if(dfs(board, word, x, y+1, n+1)) return true;
		}
		board[x][y] = temp;	// recover original value
		
		return false;	// no direction is match, return false
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
