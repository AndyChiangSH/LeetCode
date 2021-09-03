package p913_CatAndMouse;

import java.util.*;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[][] graph = {{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
//		int[][] graph = {{1},{0,2,4},{1,3},{2,4},{1,3}};
//		int[][] graph = {{1,4},{0,2,5},{1,3},{2},{0,5},{1,4}};
//		int[][] graph = {{1,3},{0},{3},{0,2}};
		
		int ans = sol.catMouseGame(graph);
		System.out.println(ans);
		if(ans == 0) {
			System.out.println("Draw...");
		}
		else if(ans == 1) {
			System.out.println("Mouse win!");
		}
		else {
			System.out.println("Cat win!");
		}
	}
	
	public int catMouseGame(int[][] graph) {
        int n = graph.length;
        State[][][] state = new State[2][n][n];
        
        Arrays.fill(state[0][0], State.ILLEGAL);
        Arrays.fill(state[1][0], State.ILLEGAL);
        for(int i = 1; i < n; i++) {
            state[0][i][0] = State.MOUSE;
            state[1][i][0] = State.ILLEGAL;
            for (int j = 1; j < n; j++) {
                if(i == j) {
                	state[0][i][j] = state[1][i][j] = State.CAT;
                }
                else {
                	state[0][i][j] = state[1][i][j] = State.DRAW;
                }
            }
        }
        
        while(true) {
            boolean isChanged = false;
            for(int i = 1; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < 2; k++) {
                        if(state[k][i][j] != State.DRAW) {
                            continue;
                        }
                        int record = 0;
                        if(k == 0) {
                            for(int u : graph[i]) {
                                record = state[1 - k][u][j].set(record);
                            }
                        } 
                        else {
                            for(int v : graph[j]) {
                                record = state[1 - k][i][v].set(record);
                            }
                        }
                        
                        State newState = State.of(record, k == 0);
                        if(newState != state[k][i][j]) {
                            isChanged = true;
                        }
                        state[k][i][j] = newState;
                    }
                }
            }
            
            if(state[1][2][1] != State.DRAW || !isChanged) {
                return state[1][2][1].getCode();
            }
        }
    }
	
	enum State {
		DRAW(0),
		MOUSE(1),
		CAT(2),
		ILLEGAL(3);
		
		private final int code;
		
		State(int code) {
			this.code = code;
		}
		
		public int getCode() {
			return this.code;
		}
		
        public boolean test(int record) {
            return (record & (1 << this.code)) != 0;
        }
        
        public int set(int record) {
            return record | (1 << this.code);
        }
        
        public static State of(int record, boolean isCat) {
            if (isCat) {
            	if(CAT.test(record)) {
            		return CAT;
            	}
            	else if(DRAW.test(record)) {
            		return DRAW;
            	}
            	else {
            		return MOUSE;
            	}
            } 
            else {
            	if(MOUSE.test(record)) {
            		return MOUSE;
            	}
            	else if(DRAW.test(record)) {
            		return DRAW;
            	}
            	else {
            		return CAT;
            	}
            }
        }
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
}
