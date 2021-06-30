package p026_RemoveDuplicatesFromSortedArray;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] input = {1, 1, 2, 3, 4, 4, 5, 5, 5};
		
		int ans = sol.removeDuplicates(input);
		System.out.println("ans = "+ans);
		for(int i = 0; i < ans; i++) {
			System.out.print(input[i]+", ");
		}
	}
	
	public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int p = 0;
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] != nums[p]) {
        		nums[++p] = nums[i];
        	}
        }
        
        return p+1;
    }
}
