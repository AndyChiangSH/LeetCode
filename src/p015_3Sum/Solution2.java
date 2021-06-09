package p015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] input = {0};
		List<List<Integer>> l = sol.threeSum(input);
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
//		 List<List<Integer>> ans = new ArrayList<>(); 
//		if(nums == null || nums.length < 3) return ans;
		
		Arrays.sort(nums);
		
		int limit = this.binarySearch(nums, 0, 0, nums.length-1);
		
		int i = 0;
		while(i < limit) {
			int left = i+1, right = nums.length-1, ni = nums[i], nl = nums[left], nr = nums[right];
			System.out.println("ni = "+ni+", nl = "+nl+", nr = "+nr);
			
			while(left < right) {
				int sum = ni+nl+nr;
				if(sum > 0) {
					right--;
				}
				else if(sum < 0) {
					left++;
				}
				else {
//					ans.add(Arrays.asList(ni, nl, nr));
					System.out.println("ni = "+ni+", nl = "+nl+", nr = "+nr);
					while(left < right && nums[++left] == nl);
                    while(left < right && nums[--right] == nr);
				}
			}
			while(i < limit && nums[++i] == ni);
		}
		
		return null;
    }
	
	public int binarySearch(int[] A, int key, int l, int h) {
		if(key < A[l]) return -1;
		if(key > A[h]) return -1;
		int low = l, high = h;
		while(low+1 < high) {
			int mid = (low+high)/2;
			if(key < A[mid]) high = mid;
			else if(key > A[mid]) low = mid;
			else return mid;
		}
		return high;
	}
	
	public void show(int[] A) {
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+", ");
		}
		System.out.println();
	}
	
	public class List<T> {
		ArrayList<T> list = new ArrayList<T>();
	}
}
