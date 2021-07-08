package p046_Permutations;

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {1, 2, 3};
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
		if(nums == null) return null;
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int len = nums.length;
        ArrayList<Integer> remain = new ArrayList<Integer>();
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        for(int i = 0; i < len; i++) {
        	remain.add(nums[i]);
        }
        
        for(int i = 0; i < len; i++) {
        	int r = remain.remove(i);
        	buffer.add(r);
        	backtracking(ans, remain, buffer, len);
        	remain.add(i);
        }
        
        return ans;
    }
	
	private void backtracking(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> remain, ArrayList<Integer> buffer, int len) {
		if(buffer.size() == len) {
			ans.add((ArrayList<Integer>) buffer.clone());
			return;
		}
		
		for(int i = 0; i < remain.size(); i++) {
        	int r = remain.remove(i);
        	buffer.add(r);
        	backtracking(ans, remain, buffer, len);
        	buffer.remove(buffer.size()-1);
        	remain.add(r);
        }
	}
}
