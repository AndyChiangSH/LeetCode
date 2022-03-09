// Solution8: Bellman ford
package p407_TrappingRainWater_II;

public class Solution8 {
	public static void main(String[] args) {
		Solution8 test = new Solution8();
//		int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};	// 4
//		int[][] heightMap = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};	// 10
//		int[][] heightMap = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};	// 0
//		int[][] heightMap = {{11,21,31},{81,9,41},{17,61,51}};	// 12
//		int[][] heightMap = {{9,9,9,9,9,9,8,9,9,9,9},{9,0,0,0,0,0,1,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,9,9,9}};	// 215
//		int[][] heightMap = {{13,16,15,18,15,15},{14,1,8,9,7,9},{19,5,4,2,5,10},{13,1,7,9,10,3},{17,7,5,10,6,1},{15,9,8,2,8,3}};
//		int[][] heightMap = {{10,9,8,7,6},{9,4,3,2,7},{8,3,1,3,8},{7,2,3,4,9},{6,7,8,9,10}};
//		int[][] heightMap = {{10,9,8,7,6},{10,4,3,2,6},{10,3,1,3,6},{10,2,3,4,6},{10,9,8,7,6}};
//		int[][] heightMap = {{10,10,10,10,10},{10,1,1,1,10},{10,1,1,1,10},{10,1,1,1,10},{10,5,10,10,10}};
//		int[][] heightMap = {{9,9,9,9,9,9,9,9,9,9},{0,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,0,9},{9,0,0,0,0,0,0,9,0,9},{9,0,9,9,9,9,0,9,0,9},{9,0,9,0,9,9,0,9,0,9},{9,0,9,0,0,0,0,9,0,9},{9,0,9,9,9,9,9,9,0,9},{9,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,9,9}};
		int[][] heightMap = {{9,9,9,9,9}, {9,0,0,0,9}, {9,9,9,0,9}, {9,0,0,0,9}, {9,0,9,9,9}, {9,0,0,0,9}, {9,9,9,0,9}, {9,0,0,0,9},{9,0,9,9,9}, {9,0,0,0,9}, {9,9,9,8,9}};
		
		System.out.println("Init:");
        test.show(heightMap);
        
		int answer = test.trapRainWater(heightMap);
		System.out.println("answer = "+answer);
	}
	
	public int trapRainWater(int[][] heightMap) {
		if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
		
		int row = heightMap.length;
		int col = heightMap[0].length;
		int[][] volume = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				volume[i][j] = heightMap[i][j];
			}
		}
		
		boolean update = true;
		boolean init = true;
		int round = 0;
		while (update) {
			round++;
			System.out.println("Round:"+round);
			update = false;
			System.out.println("----------------------------------");
			System.out.println("Scan from left top to right bottom");
			System.out.println("----------------------------------");
			for (int i = 1; i < row - 1; i++) {
				for (int j = 1; j < col - 1; j++) {
					int val = Math.max(heightMap[i][j], Math.min(volume[i - 1][j], volume[i][j - 1]));
					System.out.println("i="+i+", j="+j+", val="+val);
					if (init || val < volume[i][j]) {
						volume[i][j] = val;
						update = true;
						show(volume);
					}
				}
			}
			init = false;
			System.out.println("----------------------------------");
			System.out.println("Scan from right bottom to left top");
			System.out.println("----------------------------------");
			for (int i = row - 2; i >= 1; i--) {
				for (int j = col - 2; j >= 1; j--) {
					int val = Math.max(heightMap[i][j], Math.min(volume[i + 1][j], volume[i][j + 1]));
					System.out.println("i="+i+", j="+j+", val="+val);
					if (val < volume[i][j]) {
						volume[i][j] = val;
						update = true;
						show(volume);
					}
				}
			}
		}
		
		System.out.println("Stop!");
		System.out.println("volume:");
		show(volume);
		System.out.println("heightMap:");
		show(heightMap);
		System.out.println("Round:"+round);
		
		int sum = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (volume[i][j] - heightMap[i][j] > 0) {
					sum += volume[i][j] - heightMap[i][j];
				}
			}
		}
		
		return sum;
    }
	
	// show int 2D-array
	private void show(int[][] A) {
		System.out.print("[");
		for(int i = 0; i < A.length; i++) {
			System.out.print("[");
			for(int j = 0; j < A[i].length; j++) {
				System.out.printf("%2d", A[i][j]);
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
		System.out.println();
	}
}
