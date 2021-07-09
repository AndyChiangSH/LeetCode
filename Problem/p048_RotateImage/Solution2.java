package p048_RotateImage;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
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
        
        for(int i = 0; i < n-1; i++) {
        	for(int j = 0; j < n-1-i; j++) {
        		int temp = matrix[i][j];
            	matrix[i][j] = matrix[n-1-j][n-1-i];
            	matrix[n-1-j][n-1-i] = temp;
            }
        }
        for(int i = 0; i < n/2; i++) {
        	for(int j = 0; j < n; j++) {
        		int temp = matrix[i][j];
            	matrix[i][j] = matrix[n-1-i][j];
            	matrix[n-1-i][j] = temp;
        	}
        }
        
        return;
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
