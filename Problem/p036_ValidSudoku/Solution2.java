package p036_ValidSudoku;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		char[][] board = {{'9','3','.','.','7','.','.','.','.'},
						  {'6','.','.','1','9','5','.','.','.'},
						  {'.','9','8','.','.','1','.','6','.'},
						  {'8','.','.','.','6','.','.','.','3'},
						  {'4','.','.','8','.','3','.','.','1'},
						  {'7','.','.','.','2','.','.','.','6'},
						  {'.','6','.','.','.','.','2','8','.'},
						  {'.','.','.','4','1','9','.','.','5'},
						  {'.','.','.','.','8','.','.','7','9'}};
		System.out.println(sol.isValidSudoku(board));
	}
	
	public boolean isValidSudoku(char[][] board) {
        if(board == null) return false;
        
        boolean[] mark = new boolean[9];
        for(int i = 0; i < 9; i++) {	// check rows
        	cleanMark(mark);
        	for(int j = 0; j < 9; j++) {
        		int value = board[i][j] - '1';
        		if(value != -3) {
	        		if(mark[value]) {
	            		return false;
	            	}
	            	else {
	            		mark[value] = true;
	            	}
        		}
            }
        }
        for(int i = 0; i < 9; i++) {	// check columns
        	cleanMark(mark);
        	for(int j = 0; j < 9; j++) {
        		int value = board[j][i] - '1';
        		if(value != -3) {
        			if(mark[value]) {
        				return false;
        			}
        			else {
        				mark[value] = true;
        			}
        		}
            }
        }
        for(int i = 0; i < 9; i+=3) {	// check nine-square division
        	for(int j = 0; j < 9; j+=3) {
        		cleanMark(mark);
        		for(int k = 0; k < 3; k++) {
        			for(int l = 0; l < 3; l++) {
        				int value = board[i+k][j+l] - '1';
        				if(value != -3) {
        					if(mark[value]) {
        						return false;
        					}
        					else {
        						mark[value] = true;
        					}
        				}
            		}
        		}
            }
        }
        
        return true;
    }
	
	private void cleanMark(boolean[] mark) {	// clean all mark element to false
		for(int i = 0; i < 9; i++) {
			mark[i] = false;
		}
	}
}
