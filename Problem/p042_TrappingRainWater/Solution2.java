// solution2: two point and scan again
package p042_TrappingRainWater;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
//		int[] height = {4,2,0,3,2,5};
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1,0};
		int[] height = {2,0,0,3};
//		int[] height = {1,0};
		
		System.out.println(sol.trap(height));
	}
	
	public int trap(int[] height) {
		int len = height.length;
        if(len <= 2) return 0;
        
        int l = 0, r = len-1, lMax = 0, rMax = 0, lMaxindex = 0, rMaxindex = 0, lWater = 0, rWater = 0, totalWater = 0;
        // two point from left and right, find the pool in left and right
        while(l <= r) {
        	if(height[l] >= lMax) {		// new max height
        		lMax = height[l];
        		totalWater += lWater;
        		lWater = 0;
        		lMaxindex = l;
        	}
        	else {
        		lWater += (lMax-height[l]);
        	}
        	if(height[r] >= rMax) {		// new max height
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
        
//        System.out.println("l = "+l+", r = "+r+", lMax = "+lMax+", rMax = "+rMax+", lMaxindex = "+lMaxindex+", rMaxindex = "+rMaxindex+", lWater = "+lWater+", rWater = "+rWater+", totalWater = "+totalWater);
        
        // use smaller max height to count last pool between lMaxindex and rMaxindex
        if(lMax < rMax) {	// left max height is smaller
        	lWater = 0;
        	for(l = lMaxindex; l <= rMaxindex; l++) {
        		if(height[l] >= lMax) {
            		lMax = height[l];
            		totalWater += lWater;
            		lWater = 0;
            		lMaxindex = l;
            	}
            	else {
            		lWater += (lMax-height[l]);
            	}
        	}
        }
        else if(lMax > rMax) {	// // right max height is smaller
        	rWater = 0;
        	for(r = rMaxindex; r >= lMaxindex; r--) {
        		if(height[r] >= rMax) {
            		rMax = height[r];
            		totalWater += rWater;
            		rWater = 0;
            		rMaxindex = r;
            	}
            	else {
            		rWater += (rMax-height[r]);
            	}
        	}
        }
        else {	// left and right max height is same
        	totalWater += (lWater+rWater);
//        	System.out.println(lWater+", rWater = "+rWater+", totalWater = "+totalWater);
        	if(l == r+2 && height[r+1] < rMax) {
    			totalWater -= rMax-height[r+1];
    		}
        }
//        System.out.println("totalWater = "+totalWater);
        
        return totalWater;
    }
}
