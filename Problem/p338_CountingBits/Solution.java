package p338_CountingBits;

public class Solution {
	public static void main(String[] args) {
		int n = 8;
		Solution test = new Solution();
		int[] ans = test.countBits(n);
		test.show(ans);
	}
	
	public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        ans[0] = 0;
        for(int i = 1; i <= n; i++) {
        	if(i%2 == 0) {
        		ans[i] = ans[i/2];
        	}
        	else {
        		ans[i] = ans[i/2] + 1;
        	}
        }
        
        return ans;
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
