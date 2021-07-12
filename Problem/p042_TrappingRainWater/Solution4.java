// solution4: two point only move one
package p042_TrappingRainWater;

public class Solution4 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
//		int[] height = {4,2,0,3,2,5};
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1,0};
		int[] height = {2,0,0,0,1};
//		int[] height = {1,0};
		
		sol.showHeight(height);
		System.out.println(sol.trap(height));
	}
	
	public int trap(int height[]) {
		int len = height.length;
		if(len <= 2) return 0;
		
		int left = 0, right = len-1, maxleft = 0, maxright = 0, water = 0;
		while(left <= right) {	// stop when left and right cross
			if(height[left] < height[right]) {	// move the smaller of left and right point
				if(height[left] >= maxleft) maxleft = height[left];	// new max height
				else water += maxleft - height[left];
				left++;
			} 
			else {
				if(height[right] >= maxright) maxright = height[right];	// new max height
				else water += maxright - height[right];
				right--;
			}
		}
		
		return water;
	}
	
	private void show(int[] A) {
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i]+", ");
		}
		System.out.println();
	}
	
	private void showHeight(int[] height) {
		int max = 0, len = height.length;
		for(int i = 0; i < len; i++) {
			if(height[i] > max) {
				max = height[i];
			}
		}
		System.out.println("Height：");
		for(int i = max+1; i > 0; i--) {
			System.out.print("|");
			for(int j = 0; j < len; j++) {
				if(height[j] >= i) {
					System.out.print(" ■ ");
				}
				else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
		System.out.print("-");
		for(int j = 0; j < len; j++) {
			System.out.print("---");
		}
		System.out.print("\n ");
		for(int j = 0; j < len; j++) {
			System.out.printf("%2d ",j);
		}
		System.out.println();
	}
}
