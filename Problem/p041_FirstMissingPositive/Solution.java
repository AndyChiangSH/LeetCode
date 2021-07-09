// solution1: hashset
package p041_FirstMissingPositive;

import java.util.HashSet;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {3,2,1,5,6,7};
		System.out.println(sol.firstMissingPositive(nums));
	}
	
	public int firstMissingPositive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
        int len = nums.length;
        
        for(int i = 0; i < len; i++) {
        	set.add(nums[i]);
        }
        for(int i = 1; i < Integer.MAX_VALUE; i++) {
        	if(!set.contains(i)) {
        		return i;
        	}
        }
        
        return -1;
    }
}
