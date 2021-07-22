// case2: Farthest reachable index(FRI)
package p055_JumpGame;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] nums = {3,0,1,3,4};
		
		System.out.println(sol.canJump(nums));
	}
	
	public boolean canJump(int[] nums) {
        int len = nums.length, max = 0;
        if(len < 2) return true;
        
        for(int i = 0; i < len; i++) {
        	if(i > max) return false;	// if i is over FRI, then it's impossible to reach
        	max = Math.max(i+nums[i], max);	// new index farther than FRI
        }
        
        return true;
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
