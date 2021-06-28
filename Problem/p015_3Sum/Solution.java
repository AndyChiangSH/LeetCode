package p015_3Sum;

import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input = {-1,0,1,2,-1,-4};
		List<List<Integer>> ans = sol.threeSum(input);
		sol.show(ans);
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> ans = new List<List<Integer>>();
		List<Integer> tuple = new List<Integer>();
		tuple.list.add(1);
		tuple.list.add(2);
		tuple.list.add(3);
		ans.list.add(tuple);
		List<Integer> tuple2 = new List<Integer>();
		tuple2.list.add(6);
		tuple2.list.add(5);
		tuple2.list.add(4);
		ans.list.add(tuple2);
		List<Integer> tuple3 = new List<Integer>();
		tuple3.list.add(-1);
		tuple3.list.add(0);
		tuple3.list.add(1);
		ans.list.add(tuple3);
		
		return ans;
    }
	
	public void show(List<List<Integer>> x) {
		for(int i = 0; i < x.list.size(); i++) {
			List<Integer> y = x.list.get(i);
			for(int j = 0; j < y.list.size(); j++) {
				System.out.print(y.list.get(j)+" ");
			}
			System.out.println("");
		}
	}
	
	public class List<T> {
		ArrayList<T> list = new ArrayList<T>();
	}
}
