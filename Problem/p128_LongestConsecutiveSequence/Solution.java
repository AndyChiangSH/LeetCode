// Sort array first
package p128_LongestConsecutiveSequence;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
//		int[] nums = {100, 4, 200, 1, 3, 2};
		int[] nums = {0,3,7,2,5,8,4,6,0,1};
		Solution test = new Solution();
		int ans = test.longestConsecutive(nums);
		System.out.println("ans = " + ans);
	}
	
	public int longestConsecutive(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		
		// sort first
        Arrays.sort(nums);
//        show(nums);
        
        int max = 1;
        int cons = 1;
        for(int i = 0; i < nums.length-1; i++) {
        	if(nums[i+1] == nums[i] + 1) {	// consecutive
        		cons++;
        	}
        	else if(nums[i+1] != nums[i]) {	// stop
        		if(cons > max) {
        			max = cons;
        		}
        		cons = 1;
        	}
        }
        if(cons > max) {
			max = cons;
		}
        
        return max;
    }
	
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
