// Set
package p128_LongestConsecutiveSequence;

import java.util.HashSet;

public class Solution3 {
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
//		int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		Solution3 test = new Solution3();
		int ans = test.longestConsecutive(nums);
		System.out.println("ans = " + ans);
	}
	
	public int longestConsecutive(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
        
		// set of numbers
        for(int i = 0; i < nums.length; i++) {
        	set.add(nums[i]);
        }
        
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
        	if(!set.contains(nums[i]-1)) {	// find the first number of consecutive segment
        		int tmp = nums[i]+1;
        		int cons = 1;
        		while(set.contains(tmp)) {	// find higher numbers
        			tmp++;
        			cons++;
        		}
        		if(cons > max) {	// max consecutive number
        			max = cons;
        		}
        	}
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
