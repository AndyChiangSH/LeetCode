// solution2: mark with negative sign
package p041_FirstMissingPositive;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] nums = {-1, 0, 1, 4, 3, -2, 6};
		System.out.println(sol.firstMissingPositive(nums));
	}
	
	public int firstMissingPositive(int[] nums) {
	    int n = nums.length;
	    
	    for(int i = 0; i < n; i++) {
	    	show(nums);
	    	// if value is out of range, then set to n+1. otherwise, nothing change
	        if(nums[i] <= 0 || nums[i] > n) {
	            nums[i] = n + 1;
	        }
	    }
	    System.out.println("-------------");
	    for(int i = 0; i < n; i++) {
	    	show(nums);
	        int num = Math.abs(nums[i]);
	        // if value is n+1, skip it
	        if(num > n) {
	            continue;
	        }
	        num--;
	        // if it is valid value in [1, n], then set nums[value] to negative, 
	        // for mark that this positive integer is exist.
	        if(nums[num] > 0) {
	            nums[num] = -1 * nums[num];
	        }
	    }
	    show(nums);
	    // the value which is not negative is missing value
	    for(int i = 0; i < n; i++) {
	        if(nums[i] >= 0) {
	            return i + 1;
	        }
	    }
	    
	    // if there is no missing value, then return n+1
	    return n + 1;
	}
    
    private void show(int[] nums){
        for(int i = 0; i < nums.length; i++) {
        	System.out.print(nums[i]+" ");
        }
        System.out.print("\n");
    }
}
