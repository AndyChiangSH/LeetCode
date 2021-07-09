package p046_Permutations;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution4 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		int[] nums = {1, 2, 3, 4};
		ArrayList<ArrayList<Integer>> ans = sol.permute(nums);
		System.out.println(ans.size());
		for(int i = 0; i < ans.size(); i++) {
			ArrayList<Integer> a = ans.get(i);
			for(int j = 0; j < a.size(); j++) {
				System.out.print(a.get(j)+" ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> permute(int[] nums) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        
        backtracking(ans, nums, 0, len);
        
        return ans;
    }
	
	private void backtracking(ArrayList<ArrayList<Integer>> ans, int[] nums, int first, int len) {		
		if(first == len) {	// it is time to backtrack!
			
			for(int i = 0; i < first; i++) {
				System.out.print("  ");
			}
			for(int i = 0; i < len; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println(" -> add into answer");
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < len; i++) {	// copy value from array to arrayList
				list.add(nums[i]);
			}
			ans.add(list);	// add into answer
			return;
		}
		
//		System.out.println("first = "+first);
		for(int i = 0; i < first; i++) {
			System.out.print("  ");
		}
		for(int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		for(int i = first; i < len; i++) {
			swap(nums, first, i);	// swap first and i element
			backtracking(ans, nums, first+1, len);
			swap(nums, first, i);	// redo the swap
		}
	}
	
	private void swap(int[] nums, int f, int i) {
		int temp = nums[f];
		nums[f] = nums[i];
		nums[i] = temp;
		
		return;
	}
}
