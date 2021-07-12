// solution1: two point and merge
package p042_TrappingRainWater;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] height = {0,1,0,3,1,0,2,0,3,1,2,1,0};
//		int[] height = {4,2,0,3,2,5};
//		int[] height = {1,0,2,0,3};
		int[] height = {4,3,2,1};
		
		System.out.println(sol.trap(height));
	}
	
	public int trap(int[] height) {
		int len = height.length;
        if(len <= 2) return 0;
        
        int l = 0, r = len-1, lMax = 0, rMax = 0, lMaxindex = 0, rMaxindex = 0, lWater = 0, rWater = 0, totalWater = 0;
        while(l < r) {
        	if(height[l] >= lMax) {
        		lMax = height[l];
        		totalWater += lWater;
        		lWater = 0;
        		lMaxindex = l;
        	}
        	else {
        		lWater += (lMax-height[l]);
        	}
        	if(height[r] >= rMax) {
        		rMax = height[r];
        		totalWater += rWater;
        		rWater = 0;
        		rMaxindex = r;
        	}
        	else {
        		rWater += (rMax-height[r]);
        	}
        	l++;
        	r--;
        }
        
        System.out.println("l = "+l+", r = "+r+", lMax = "+lMax+", rMax = "+rMax+", lMaxindex = "+lMaxindex+", rMaxindex = "+rMaxindex+", lWater = "+lWater+", rWater = "+rWater+", totalWater = "+totalWater);
        
        totalWater += (lWater+rWater);
        if(l == r) {	// overlap
        	int mid = height[l];
        	if(lMax > mid && rMax > mid) {
        		if(lMax > rMax) {
        			totalWater += rMax-mid;
            		totalWater -= (lMax-rMax)*(l-lMaxindex-1);
            	}
            	else {
            		totalWater += lMax-mid;
            		totalWater -= (rMax-lMax)*(rMaxindex-r-1);
            	}
        	}
        	else if(lMax > mid) {
        		totalWater -= (lMax-mid)*(l-lMaxindex-1);
        	}
        	else if(rMax > mid) {
        		totalWater -= (rMax-mid)*(rMaxindex-r-1);
        	}
        }
        else {	// cross
        	if(lMax > rMax) {
        		totalWater -= (lMax-rMax)*(l-lMaxindex-1);
        	}
        	else if(lMax < rMax) {
        		totalWater -= (rMax-lMax)*(rMaxindex-r-1);
        	}
        }
//        System.out.println("totalWater = "+totalWater);
        
        return totalWater;
    }
}
