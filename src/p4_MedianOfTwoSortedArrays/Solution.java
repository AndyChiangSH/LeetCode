package p4_MedianOfTwoSortedArrays;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if(m > n) return findMedianSortedArrays(nums2, nums1);
		if(n == 0) return (double)-1;
		
		int imin = 0, imax = m, half = (m+n+1)/2;
		
		while(imin <= imax)
		{
			int i = (imin+imax)/2;
			int j = half-i;
			if(i < m && nums2[j-1] > nums1[i])	// i is too small, must increase it
			{
				imin = i+1;
			}
			else if(i > 0 && nums1[i-1] > nums2[j])	// i is too big, must decrease it
			{
				imax = i-1;
			}
			else	// i is perfect
			{
				int max_left;
				
				if(i == 0)	max_left = nums2[j-1];
				else if(j == 0) max_left = nums1[i-1];
				else max_left = Math.max(nums2[j-1], nums1[i-1]);
				
				if((m+n)%2 == 1) return (double)max_left;
				
				int min_right;
				
				if(i == m) min_right = nums2[j];
				else if(j == n) min_right = nums1[i];
			    else min_right = Math.min(nums2[j], nums1[i]);
				
				return ((double)(max_left+min_right))/2;
			}
		}
		
		return (double)-1;
    }
}
