package p054_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[][] matrix = {{1}, {2}, {3}};
		List<Integer> ans = sol.spiralOrder(matrix);
		sol.show(ans);
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return answer;
        
        int rowB = 0, colB = 0, rowE = matrix.length-1, colE = matrix[0].length-1;
        while(rowB <= rowE && colB <= colE){
            for(int i = colB; i <= colE; i++) {	// add a line on top
                answer.add(matrix[rowB][i]);
            }
            rowB++;
            for(int i = rowB; i <= rowE; i++) {	// add a line on right
                answer.add(matrix[i][colE]);
            }
            colE--;
            if(rowB <= rowE){	// if rowB and rowE are not cross
                for(int i = colE; i >= colB; i--) {	// add a line on bottom
                    answer.add(matrix[rowE][i]);
                }
                rowE--;
            }
            if(colB <= colE){	// if colB and colE are not cross
                for(int i = rowE; i >= rowB; i--) {	// add a line on left
                    answer.add(matrix[i][colB]);
                }  
                colB++;
            }            
        }
        
        return answer;
    }
	
	// show int 1D-arrayList
	private void show(List<Integer> A) {
		int len = A.size();
		System.out.print("[");
		for(int i = 0; i < len; i++) {
			System.out.print(A.get(i));
			if(i != len-1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
