package p033_SearchInRotatedSortedArray;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {0,1,2,3,4};
		int target = 5;
		System.out.println(sol.search(nums, target));
	}
	
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length-1;
		// when left is over right, then break the loop
		while(left <= right) {
			int mid = right - (right-left)/2;	// mid is the middle between left and right (close right)
//			System.out.println("left="+left+", right="+right+", mid="+mid);
			if(nums[mid] == target) {	// found target
				return mid;
			}
			else if(nums[mid] <= nums[left]) {	// if k is in left section, it means right section is continuous
				if(target > nums[mid] && target <= nums[right]) left = mid+1;	// if target is in right range
				else right = mid-1;	// otherwise
			}
			else if(nums[mid] > nums[left]) {	// if k is in right section, it means left section is continuous
				if(target >= nums[left] && target < nums[mid]) right = mid-1;	// if target is in left range
				else left = mid+1;	// otherwise
			}
		}
		
		return -1;	// not found
	}
}
