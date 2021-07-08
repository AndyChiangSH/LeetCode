package p046_Permutations;

import java.util.ArrayList;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
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
	
	List<List<Integer>> ans = new ArrayList<>();
	static List<Integer> buffer = new ArrayList<>();
	static int[] nums;
	static int len;
	static boolean[] mark;
	
	public List<List<Integer>> permute(int[] nums) {
		if(nums == null) return null;
		
		this.nums = nums;
        len = nums.length;
        mark = new boolean[len];
        
        for(int i = 0; i < len; i++) {
        	mark[i] = true;
        	buffer.add(nums[i]);
        	backtracking(0);
        	buffer.remove(0);
        	mark[i] = false;
        }
        
        return ans;
    }
	
	private void backtracking(int d) {
		if(d == len-1) {
			ans.add(new ArrayList<>(buffer));
			return;
		}
		
		for(int i = 0; i < len; i++) {
			if(!mark[i]) {
				mark[i] = true;
	        	buffer.add(nums[i]);
	        	backtracking(d+1);
	        	buffer.remove(d+1);
	        	mark[i] = false;
			}
		}
	}
}
