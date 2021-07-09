package p048_RotateImage;

public class Solution3 {
	
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println("Before:");
		sol.show(matrix);
		
		sol.rotate(matrix);
		
		System.out.println("\nAfter:");
		sol.show(matrix);
	}
	
	public void rotate(int[][] matrix) {
        if(matrix.length == 1) return;
        int n = matrix.length;
        
        // Rotate 90 degrees for four corners
        for(int i = 0; i < (n+1)/2; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
        
        return;
    }
	
	private void show(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			System.out.println();
		}
		
		return;
	}
}
