package p026_RemoveDuplicatesFromSortedArray;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input = {};
		
		int ans = sol.removeDuplicates(input);
		System.out.println("ans = "+ans);
		for(int i = 0; i < ans; i++) {
			System.out.print(input[i]+", ");
		}
	}
	
	public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int p = 1, n = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] != n) {
        		n = nums[i];
        		nums[p] = nums[i];
        		p++;
        	}
        }
        
        return p;
    }
}
