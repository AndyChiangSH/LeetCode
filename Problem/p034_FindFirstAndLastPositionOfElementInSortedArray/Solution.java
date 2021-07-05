package p034_FindFirstAndLastPositionOfElementInSortedArray;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {2, 2, 2};
		int target = 2;
		int[] ans = sol.searchRange(nums, target);
		System.out.println("["+ans[0]+", "+ans[1]+"]");
	}
	
	public int[] searchRange(int[] nums, int target) {
        if(nums == null) return null;
        
        int len = nums.length, left = 0, right = len-1, first = -1, last = -1;
        while(left <= right) {	// bineary search to find the target: O(logN)
        	int mid = right - (right-left)/2;	// mid is the middle between left and right (close right)
//			System.out.println("searchRange: left="+left+", right="+right+", mid="+mid);
        	if(nums[mid] == target) {	// if target found
        		if(mid != 0 && mid != len-1 && nums[mid-1] == target && nums[mid+1] == target) {	// if it is in the middle of the section
        			first = searchLeft(nums, target, left, mid-1);
        			last = searchRight(nums, target, mid+1, right);
        		}
        		else if(mid != 0 && nums[mid-1] == target) {	// if it is the first element of the section
        			first = searchLeft(nums, target, left, mid-1);
        			last = mid;
        		}
        		else if(mid != len-1 && nums[mid+1] == target) {	// if it is the last element of the section
        			first = mid;
        			last = searchRight(nums, target, mid+1, right);
        		}
        		else {	// if it is only one element of the section
        			first = last = mid;
        		}
        		break;
        	}
        	else if(nums[mid] < target) {	// if mid is small than target, than move left to mid
        		left = mid+1;
        	}
        	else {	// if mid is larger than target, than move right to mid
        		right = mid-1;
        	}
        }
        int[] ans = {first, last};
    	return ans;
    }
	
	private int searchLeft(int[] nums, int target, int l, int r) {
		int left = l, right = r;
        while(left <= right) {	// bineary search to find the first target: O(logN)
        	int mid = right - (right-left)/2;	// mid is the middle between left and right (close right)
        	if(nums[mid] == target) {	// if target found
        		if(mid == 0) {
        			return mid;
        		}
        		else if(nums[mid-1] == target && nums[mid+1] == target) {	// if it is not the first target
        			right = mid-1;
        		}
        		else if(nums[mid+1] == target) {
        			return mid;
        		}
        	}
        	else {
        		left = mid+1;	// move left
        	}
        }
        
        return -1;
	}
	
	private int searchRight(int[] nums, int target, int l, int r) {
		int left = l, right = r;
        while(left <= right) {	// bineary search to find the last target: O(logN)
        	int mid = right - (right-left)/2;	// mid is the middle between left and right (close right)
        	if(nums[mid] == target) {	// if target found
        		if(mid == nums.length-1) {
        			return mid;
        		}
        		else if(nums[mid-1] == target && nums[mid+1] == target) {	// if it is not the last target
        			left = mid+1;
        		}
        		else if(nums[mid-1] == target) {
        			return mid;
        		}
        	}
        	else {
        		right = mid-1;	// move right
        	}
        }
        
        return -1;
	}
}
