package p056_MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
//		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] intervals = {{1, 2}, {4, 5}, {2, 3}};
		sol.show(intervals);
		
		int[][] answer = sol.merge(intervals);
		System.out.println("Answer:");
		sol.show(answer);
	}
	
	public int[][] merge(int[][] intervals) {
		int len = intervals.length;
		if(len <= 1) return intervals;
		
		sort(intervals);	// merge sort
		
		List<int[]> answer = new ArrayList<>();
		int min = intervals[0][0], max = intervals[0][1];
		
		for(int i = 1; i < len; i++) {
			int start = intervals[i][0], end = intervals[i][1];
			if(start <= max) {
				max = Math.max(max, end);
			}
			else {
				answer.add(new int[] {min, max});
				min = start;
				max = end;
			}
		}
		answer.add(new int[] {min, max});
		
        return answer.toArray(new int[answer.size()][2]);
    }
	
	public static void sort(int[][] a)
	{
		int[][] aux = new int[a.length][2];
		sort(a, aux, 0, a.length-1);
	}
	
	private static void sort(int[][] a, int[][] aux, int lo, int hi)
	{
		if(hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		mergeTwo(a, aux, lo, mid, hi);
	}
	
	private static void mergeTwo(int[][] a, int[][] aux, int lo, int mid, int hi)
	{
		for(int k = lo; k <= hi; k++) aux[k] = a[k];
		
		int i = lo, j = mid+1;
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(aux[i][0] < aux[j][0]) a[k] = aux[i++];
			else if(aux[i][0] > aux[j][0]) a[k] = aux[j++];
			else {
				if(aux[i][1] <= aux[j][1]) a[k] = aux[i++];
				else a[k] = aux[j++];
			}
		}
	}
	
	// show int 2D-array
	private void show(int[][] A) {
		System.out.print("[");
		for(int i = 0; i < A.length; i++) {
			System.out.print("[");
			for(int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j]);
				if(j != A[i].length-1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
			if(i != A.length-1) {
				System.out.print(",\n ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
