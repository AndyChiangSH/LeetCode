// solution5: stack
package p042_TrappingRainWater;

import java.util.Stack;

public class Solution5 {
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
//		int[] height = {4,2,0,3,2,5};
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1,0};
//		int[] height = {2,0,0,0,1};
//		int[] height = {1,0};
		int[] height = {5,4,3,2,1,2,3,4,5};
		
		sol.showHeight(height);
		System.out.println(sol.trap(height));
	}
	
	public int trap(int height[]) {
		int len = height.length;
		if(len <= 2) return 0;
		
		Stack<Integer> stack = new Stack<Integer>();	// stack for previous index
        int totalWater = 0;
        for(int right = 0; right < len; right++) {		// scan height array once
        	System.out.println("right = "+right);
        	// if top of stack is smaller than right,
        	// then pop out and count water
            while(!stack.isEmpty() && height[stack.peek()] < height[right]) {
                int bottom = stack.pop();
                System.out.println("pop "+bottom);
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                // Identified water trapped = width * height,
                // width is from left to right, 
                // and height is the smaller of left and right minus bottom 
                System.out.println("left = "+left+", right = "+right+", bottom = "+bottom);
                int water = (right-left-1)*(Math.min(height[right], height[left])-height[bottom]);
                System.out.println("water = "+water);
                totalWater += water;
            }
            stack.push(right);	// push index into stack
            System.out.println("push "+right);
        }
        
        return totalWater;
	}
	
	private void show(int[] A) {
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i]+", ");
		}
		System.out.println();
	}
	
	// show histogram of height
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
