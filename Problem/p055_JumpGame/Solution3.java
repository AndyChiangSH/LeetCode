// case3: Latest reachable index(LRI)
package p055_JumpGame;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int[] nums = {3,0,1,3,4};
		
		System.out.println(sol.canJump(nums));
	}
	
	public boolean canJump(int[] nums) {
        int len = nums.length, last = len-1;
        for(int i = len-2; i >= 0; i--) {
        	if(i+nums[i] >= last) last = i;	// smaller LRI
        }
        return last == 0;	// if LRI is not at 0 at the end, then it's impossible to reach goal
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
