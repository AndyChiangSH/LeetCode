// solution3: scan and scan back again
package p042_TrappingRainWater;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
//		int[] height = {4,2,0,3,2,5};
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1,0};
//		int[] height = {2,0,0,0,3};
//		int[] height = {1,0};
		int[] height = {4,3,2,1,0};
		
		sol.showHeight(height);
		System.out.println(sol.trap(height));
	}
	
	public int trap(int[] height) {
		int len = height.length;
        if(len <= 2) return 0;
        
        int[] rmax = new int[len];	// array for max height from right to left
        int lmax = height[0], s = 0, water = 0;
        for(int i = len-1; i >= 0; i--) {	// find max height from right to left
        	int r = height[i];
        	if(r > s) s = r;
        	rmax[i] = s;
        }
        s = 0;
        for(int i = 0; i < len; i++) {		// find max height from left to right
        	int l = height[i];
        	if(l > s) s = l;
        	water += Math.min(rmax[i], s) - l;	// water is the smaller of the left and right max height
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
