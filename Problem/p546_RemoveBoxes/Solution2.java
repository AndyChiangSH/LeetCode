package p546_RemoveBoxes;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
//		int[] boxes = {1,3,2,2,2,3,4,3,1};
//		int[] boxes = {1,2,1,1,3};
//		int[] boxes = {1,2,1,2,1};
//		int[] boxes = {1,2,1};
		int[] boxes = {1,2,2,1,1,1,2,1,1,2,1,2,1,1,2,2,1,1,2,2,1,1,1,2,2,2,2,1,2,1,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,1,1,1,2,2,1,2,1,2,2,1,2,1,1,1,2,2,2,2,2,1,2,2,2,2,2,1,1,1,1,1,2,2,2,2,2,1,1,1,1,2,2,1,1,1,1,1,1,1,2,1,2,2,1};
		System.out.println(sol.removeBoxes(boxes));
	}
	
	public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        System.out.println("len = "+len);
        int[][] dp = new int[len][len];
        int[][] bonus = new int[len][len];
        
        for(int i = 0; i < len; i++) {
        	dp[i][i] = 1;
        }
        for(int i = 1; i < len; i++) {
        	for(int j = 0; j < len-i; j++) {
        		int max = 0, max_bonus = 0;
        		for(int k = 0; k < i; k++) {
        			int sum = dp[j][j+k] + dp[j+k+1][j+i];
        			if(sum > max) {
        				max = sum;
        				max_bonus = 0;
        			}
        			else if(sum == max) {
        				int bonus_sum = bonus[j][j+k] + bonus[j+k+1][j+i];
        				if(bonus_sum > max_bonus) {
        					max_bonus = bonus_sum;
        				}
        			}
        		}
        		dp[j][j+i] += max;
        		if(boxes[j] == boxes[j+i]) {
        			max_bonus += 2;
        			dp[j][j+i] += max_bonus;
        			bonus[j][j+i] = max_bonus;
        		}
        	}
        }
        
        show(dp);
        System.out.println("---------------------------------");
//        show(bonus);
        
        return dp[0][len-1];
    }
	
	// show int 2D-array
	private void show(int[][] A) {
		System.out.print("[");
		for(int i = 0; i < A.length; i++) {
			System.out.print("[");
			for(int j = 0; j < A[i].length; j++) {
				System.out.printf("%4d", A[i][j]);
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
