// case1: Dynamic programming
package p055_JumpGame;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {3,0,1,3,4};
		
		System.out.println(sol.canJump(nums));
	}
	
	public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len < 2) return true;
        int[] dp = new int[len];	// dp array to put farthest reachable index
        
        for(int i = 0; i < len; i++) {
        	for(int j = i; j <= Math.min(len-1, dp[i]); j++) {	// range from i to farthest reachable index
        		dp[j] = j+nums[j];
        		if(dp[j] >= len - 1) {	// if reach the end
            		show(dp);
            		return true;
            	}
        	}
        }
        show(dp);
        
        return false;
    }
	
	// show int 1D-array
	private void show(int A[]) {
		int len = A.length;
		System.out.print("[");
		for(int i = 0; i < len; i++) {
			System.out.print(A[i]);
			if(i != len-1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
