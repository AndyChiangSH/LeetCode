package p011_ContainerWithMostWater;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input = {4,3,2,1,0,1,2,3,4,5};
		int ans = sol.maxArea(input);
		System.out.println(ans);
	}
	
	public int maxArea(int[] height) {
        int left = 0, right = height.length-1, maxHeight = 0, maxWater = 0;
        while(left < right) {
        	while(height[left] <= maxHeight && left != height.length-1) left++;
        	while(height[right] <= maxHeight && right != 0) right--;
        	maxHeight = Math.min(height[left], height[right]);
        	maxWater = Math.max(maxWater, maxHeight*(right-left));
        }
        
        return maxWater;
    }
}
