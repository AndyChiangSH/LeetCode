// show
package resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Show {
	public static void main(String[] args) {
		Show test = new Show();
		
		int[] A = {1,2,3,4,6,-1};
//		char[] A = {'A','b','@','3'};
//		String[] A = {"Abc","dfG","ggh"};
//		float[] A = {(float) 1, (float) 2.34, (float) 8.8};
//		double[] A = {1, 2.34, 8.8};
//		boolean A[] = {true, false, 1>0};
//		ArrayList<Integer> B = new ArrayList<Integer>();
//		for(int i = 0; i < A.length; i++) {
//			B.add(A[i]);
//		}
		
//		int[][] A = {{1, 2}, {3, 4}, {5, 6}};
//		
//		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
//		for(int i = 0; i < A.length; i++) {
//			ArrayList<Integer> b = new ArrayList<Integer>();
//			for(int j = 0; j < A[i].length; j++) {
//				b.add(A[i][j]);
//			}
//			B.add(b);
//		}
		
//		int[][][] A = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};

		test.show(A);
	}
	
	// show int 1D-array
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
	
	// show float 1D-array
	private void show(float A[]) {
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
	
	// show double 1D-array
	private void show(double A[]) {
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
	
	// show char 1D-array
	private void show(char A[]) {
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
	
	// show string 1D-array
	private void show(String A[]) {
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
	
	// show boolean 1D-array
	private void show(boolean A[]) {
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
	
	// show int 1D-arrayList
	private void show(ArrayList<Integer> A) {
		int len = A.size();
		System.out.print("[");
		for(int i = 0; i < len; i++) {
			System.out.print(A.get(i));
			if(i != len-1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
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
	
	// show int 2D-arrayList
	private void show(ArrayList<ArrayList<Integer>> A) {
		System.out.print("[");
		for(int i = 0; i < A.size(); i++) {
			System.out.print("[");
			ArrayList a = A.get(i);
			for(int j = 0; j < a.size(); j++) {
				System.out.print(a.get(j));
				if(j != a.size()-1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
			if(i != A.size()-1) {
				System.out.print(",\n ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
	
	// show int 3D-array
	private void show(int[][][] A) {
		System.out.print("[");
		for(int i = 0; i < A.length; i++) {
			System.out.print("[");
			for(int j = 0; j < A[i].length; j++) {
				System.out.print("[");
				for(int k = 0; k < A[j].length; k++) {
					System.out.print(A[i][j][k]);
					if(k != A[i].length-1) {
						System.out.print(", ");
					}
				}
				System.out.print("]");
				if(j != A.length-1) {
					System.out.print(", ");
				}			}
			System.out.print("]");
			if(i != A.length-1) {
				System.out.print(",\n ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
