package p033_SearchInRotatedSortedArray;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] nums = {7,0,1,2,3,5,6};
		int target = 5;
		System.out.println(sol.search(nums, target));
	}
	
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) return -1; 
	    
		int left = 0, right = nums.length-1;
		if(nums[left] == target) return left;
		if(nums[right] == target) return right;
		while(right > left+1) {
			int mid = right - (right-left)/2;
			if(nums[mid] == target) {
				return mid;
			}
			else if(nums[mid] < nums[left]) {
				if(target > nums[mid] && target < nums[right]) left = mid;
				else right = mid;
			}
			else if(nums[mid] > nums[left]) {
				if(target > nums[left] && target < nums[mid]) right = mid;
				else left = mid;
			}
		}
		
		return -1;
	}
}
