package p056_MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[][] intervals = {{8,10} ,{2,6}, {15,18}, {1,3}, {2, 4}, {8, 8}, {2, 6}};
//		int[][] intervals = {{4, 5}, {2, 3}, {1, 2}};
		sol.show(intervals);
		
		int[][] answer = sol.merge(intervals);
		System.out.println("Answer:");
		sol.show(answer);
	}
	
	public int[][] merge(int[][] intervals) {
		int len = intervals.length;
		if(len <= 1) return intervals;
		
		sort(intervals);	// quick sort
		
		List<int[]> answer = new ArrayList<>();
		int min = intervals[0][0], max = intervals[0][1], top = 0;
		
		for(int i = 1; i < len; i++) {
			int start = intervals[i][0], end = intervals[i][1];
			if(start <= max) {	// merge into interval
				max = Math.max(max, end);	// max interval end
			}
			else {	// two interval are not overlapping
				answer.add(new int[] {min, max});
				min = start;	// start of next interval
				max = end;		// end of next interval
			}
		}
		answer.add(new int[] {min, max});	// last interval
		
        return answer.toArray(new int[answer.size()][2]);	// convert from arrayList to array
    }
	
	public static void sort(int[][] a)
	{
		shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(int[][] a, int lo, int hi)
	{
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private static int partition(int[][] a, int lo, int hi)
	{
		int i = lo, j = hi + 1;
		
		while(true)
		{
			while(a[++i][0] < a[lo][0] || (a[i][0] == a[lo][0] && a[i][1] <= a[lo][1]))
				if(i == hi) break;
			
			while(a[lo][0] < a[--j][0] || (a[j][0] == a[lo][0] && a[j][1] > a[lo][1]))
				if(j == lo) break;
			
			if(i >= j) break;
			exch(a, i, j);
		}
		
		exch(a, lo, j);
		return j;
	}
	
	private static void exch(int[][] a, int i, int j)
	{
		int[] temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void shuffle(int[][] a)
	{
		int N = a.length;
		for(int i = 0; i < N; i++)
		{
			int r = (int)(Math.random()*(i));
			exch(a, i, r);
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
