// solution4: mark by swap(for loop)
package p041_FirstMissingPositive;

public class Solution4 {
	
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		int[] nums = {1, 1};
		System.out.println(sol.firstMissingPositive(nums));
	}
	
	public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length;){
            if(nums[i] > 0 && i+1 != nums[i] && nums[i]<=nums.length) {
                if(nums[nums[i]-1] == nums[i])
                    i++;
                else
                    swap(nums,i, nums[i]-1);
            }
            else {
                i++;
            }
        }
        int count = 1;
        for(int i = 0; i < nums.length; i++, count++) {
            if(nums[i] != count) return count;
        }
        return count;
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
