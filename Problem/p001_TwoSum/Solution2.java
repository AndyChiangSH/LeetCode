// solution2 - binary search: O(2NlogN)
package p001_TwoSum;

public class Solution2 
{
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		Solution2 test = new Solution2();
		int[] ans = test.twoSum(nums, target);
		
		if(ans == null) {
			System.out.println("Not Found!");
		}
		else {
			System.out.println("["+ans[0]+", "+ans[1]+"]");
		}
	}
	
	public int[] twoSum(int[] nums, int target) 
	{
		int len = nums.length;
		int copy[] = new int[len];
		System.arraycopy(nums, 0, copy, 0, len);
		
        quickSort(nums, 0, len-1);	// sort first: O(NlogN)
          
        for(int i = 0; i < len-1; i++) {	// binary search each element: O(NlogN)
        	int left = i, right = len;
        	while(left+1 < right) {
        		int mid = (right+left)/2;
        		if(nums[mid] > target-nums[i]) {
        			right = mid;
        		}
        		else if(nums[mid] < target-nums[i]) {
        			left = mid;
        		}
        		else{
        			int[] ans = {searchFromStart(copy, nums[i]), searchFromEnd(copy, nums[mid])};
        			return ans;
        		}
        	}
        }
        return null;
    }
	
	public void quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);

	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	private int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
	
	private int searchFromStart(int[] arr, int n) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == n) {
				return i;
			}
		}
		return -1;
	}
	
	private int searchFromEnd(int[] arr, int n) {
		for(int i = arr.length-1; i >= 0; i--) {
			if(arr[i] == n) {
				return i;
			}
		}
		return -1;
	}
}
