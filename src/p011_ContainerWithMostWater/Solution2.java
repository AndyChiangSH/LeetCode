package p011_ContainerWithMostWater;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] input = {4,3,2,1,0,1,2,3,4,5};
		int ans = sol.maxArea(input);
		System.out.println(ans);
	}
	
	public int maxArea(int[] height) {
        int n = height.length, left = 0, right = n-1, maxHeight = 0, maxWater = 0;
        // scan array from the both side
        // if right and left are cross, then end scaning
        while(left < right) {
        	while(height[left] <= maxHeight && left != n-1) left++;	// find left limit
        	while(height[right] <= maxHeight && right != 0) right--;	// find right limit
        	maxHeight = Math.min(height[left], height[right]);	// maxHeight is the smaller one
        	maxWater = Math.max(maxWater, maxHeight*(right-left));	// maxHeight*(right-left) is the new capacity
        }
        
        return maxWater;	// return answer
    }
}
