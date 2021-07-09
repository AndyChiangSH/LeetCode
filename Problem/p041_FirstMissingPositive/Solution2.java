// solution2: mark with negative sign
package p041_FirstMissingPositive;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] nums = {-1, 0, 1, 7, 3, -2, 4};
		System.out.println("X = "+sol.firstMissingPositive(nums));
	}
	
	public int firstMissingPositive(int[] nums) {
	    int n = nums.length;
	    
	    System.out.println("set out of range value to n+1");
	    for(int i = 0; i < n; i++) {
	    	
	    	System.out.println("i = "+i);
	    	show(nums);
	    	
	    	// if value is out of range, then set to n+1. otherwise, nothing change
	        if(nums[i] <= 0 || nums[i] > n) {
	            nums[i] = n + 1;
	        }
	    }
	    
	    System.out.println("-------------");
	    System.out.println("set negative");
	    for(int i = 0; i < n; i++) {
	    	
	    	System.out.println("i = "+i);
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
	    
	    System.out.println("-------------");
	    System.out.println("final：");
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
