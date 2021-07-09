// solution3: mark by swap
package p041_FirstMissingPositive;

public class Solution3 {
	
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int[] nums = {1, 1};
		System.out.println(sol.firstMissingPositive(nums));
	}
	
	public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while(i < n) {
        	// if value is in [1, n] and the value of mark position is not same
            if (nums[i] >= 1 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);	// swap two value
            }
            else {
                i++;
            }
        }
        i = 0;
        while(i < n) {
        	if(nums[i++] != i) return i;	// it nums should be 1, 2, ..., n, return the missing value
        }
        
        // if there is no missing value, then return n+1
        return n+1;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void show(int[] nums){
        for(int i = 0; i < nums.length; i++) {
        	System.out.print(nums[i]+" ");
        }
        System.out.print("\n\n");
    }
}
