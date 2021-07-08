package p046_Permutations;

import java.util.ArrayList;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
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
	
	public List<List<Integer>> permute(int[] nums) {
		if(nums == null) return null;
		
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> buffer = new ArrayList<>();
        int len = nums.length;
        boolean[] mark = new boolean[len];
        
        for(int i = 0; i < len; i++) {
        	mark[i] = true;
        	buffer.add(nums[i]);
        	backtracking(ans, buffer, nums, mark, 0, len);
        	buffer.remove(0);
        	mark[i] = false;
        }
        
        return ans;
    }
	
	private void backtracking(List<List<Integer>> ans, List<Integer> buffer, int[] nums, boolean[] mark, int d, int len) {
		if(d == len-1) {
			ans.add(new ArrayList<>(buffer));
			return;
		}
		
		for(int i = 0; i < len; i++) {
			if(!mark[i]) {
				mark[i] = true;
	        	buffer.add(nums[i]);
	        	backtracking(ans, buffer, nums, mark, d+1, len);
	        	buffer.remove(d+1);
	        	mark[i] = false;
			}
		}
	}
}
