package p054_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] matrix = {{1}, {2}, {3}};
		List<Integer> ans = sol.spiralOrder(matrix);
		sol.show(ans);
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> answer = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return answer;
        
        int upper = 0, lower = matrix.length-1, left = 0, right = matrix[0].length-1, dir = 0;
        int x = 0, y = -1;
        while(upper <= lower && left <= right) {
        	if(dir == 0) {	// go right
        		y++;
        	}
        	else if(dir == 1) {	// go down
        		x++;
        	}
        	else if(dir == 2) {	// go left
        		y--;
        	}
        	else if(dir == 3) {	// go top
        		x--;
        	}
        	
//        	System.out.println("["+x+", "+y+"]");
        	answer.add(matrix[x][y]);
        	
        	if(dir == 0 && y == right) {	// turn down
        		dir = 1;
        		upper++;
        	}
        	else if(dir == 1 && x == lower) {	// turn left
        		dir = 2;
        		right--;
        	}
        	else if(dir == 2 && y == left) {	// turn up
        		dir = 3;
        		lower--;
        	}
        	else if(dir == 3 && x == upper) {	// turn right
        		dir = 0;
        		left++;
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
