package p048_RotateImage;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Before:");
		sol.show(matrix);
		
		sol.rotate(matrix);
		
		System.out.println("\nAfter:");
		sol.show(matrix);
	}
	
	public void rotate(int[][] matrix) {
        if(matrix.length == 1) return;
        int n = matrix.length;
        
        // swap diagonal depend on axis
        for(int i = 0; i < n-1; i++) {
        	for(int j = 0; j < n-1-i; j++) {
            	swap(matrix, i, j, n-1-j, n-1-i);
            }
        }
        // swap upside down
        for(int i = 0; i < n/2; i++) {
        	for(int j = 0; j < n; j++) {
        		swap(matrix, i, j, n-1-i, j);
        	}
        }
        
        return;
    }
	
	private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
		int temp = matrix[i1][j1];
    	matrix[i1][j1] = matrix[i2][j2];
    	matrix[i2][j2] = temp;
	}
	
	private void show(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		return;
	}
}
