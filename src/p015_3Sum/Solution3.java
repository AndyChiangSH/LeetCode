// solution3: correct solution
package p015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int[] input = {0,0,0};
		List<List<Integer>> test = sol.threeSum(input);
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>(); 
		if(nums == null || nums.length < 3) return ans;	// return empty array
		
		Arrays.sort(nums);	// sorted first
		
		int limit = 0;
		while(limit < nums.length-1 && nums[limit] <= 0) limit++;	// find the first positive integer
		
		int i = 0;
		while(i < limit) {
			int left = i+1, right = nums.length-1, ni = nums[i];
			
			while(left < right) {
				int nl = nums[left], nr = nums[right], sum = ni+nl+nr;	// three sum
				if(sum > 0) {	// if sum is larger than 0, then right minus 1
					right--;
				}
				else if(sum < 0) {	// if sum is smaller than 0, then left plus 1
					left++;
				}
				else {	// one of the answers
					ans.add(Arrays.asList(ni, nl, nr));
					while(left < right && nums[++left] == nl);	// skip same value from left
					while(left < right && nums[--right] == nr);	// skip same value from right
				}
			}
			while(i < limit && nums[++i] == ni);	// skip same value of i
		}
		
		return ans;
	}
	
	public class List<T> {
		ArrayList<T> list = new ArrayList<T>();
	}
}
