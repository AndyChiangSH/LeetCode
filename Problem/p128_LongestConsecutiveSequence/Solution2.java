// Hash map and mark visited
package p128_LongestConsecutiveSequence;

import java.util.HashMap;

public class Solution2 {
	public static void main(String[] args) {
//		int[] nums = {100, 4, 200, 1, 3, 2};
		int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		Solution2 test = new Solution2();
		int ans = test.longestConsecutive(nums);
		System.out.println("ans = " + ans);
	}
	
	public int longestConsecutive(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		
		HashMap<Integer, Boolean> Map = new HashMap<Integer, Boolean>();
        
        for(int i = 0; i < nums.length; i++) {
        	Map.put(nums[i], false);	// mark all numbers is False
        }
        
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
        	boolean visited = Map.get(nums[i]);
        	if(!visited) {	// not visited
        		Map.put(nums[i], true);
        		int cons = 1;
        		int tmp = nums[i];
        		while(true) {	// search lower numbers
        			tmp--;
        			if(Map.containsKey(tmp)) {
        				cons++;
        				Map.put(tmp, true);
        			}
        			else {
        				break;
        			}
        		}
        		tmp = nums[i];
        		while(true) {	// search higher numbers
        			tmp++;
        			if(Map.containsKey(tmp)) {
        				cons++;
        				Map.put(tmp, true);
        			}
        			else {
        				break;
        			}
        		}
        		if(cons > max) {	// max consecutive number
        			max = cons;
        		}
        	}
        }
        
        return max;
    }
	
	private void show(int A[]) {
		int len = A.length;
		System.out.print("[");
		for(int i = 0; i < len; i++) {
			System.out.print(A[i]);
			if(i != len-1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
