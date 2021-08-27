package p913_CatAndMouse;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
//		int[][] graph = {{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
//		int[][] graph = {{1},{0,2,4},{1,3},{2,4},{1,3}};
//		int[][] graph = {{1,4},{0,2,5},{1,3},{2},{0,5},{1,4}};
		int[][] graph = {{1,3},{0},{3},{0,2}};
		
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
        int node_num = graph.length;
        int[] hole_distance = new int[node_num];
        for(int i = 0; i < node_num; i++) {
        	hole_distance[i] = Integer.MAX_VALUE;
        }
        
        // bfs for distance from hole
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        hole_distance[0] = 0;
        while(!queue.isEmpty()) {
        	int node = queue.poll();
        	int curr_distance = hole_distance[node];
        	int[] adjs = graph[node];
        	
        	for(int i = 0; i < adjs.length; i++) {
        		if(curr_distance+1 < hole_distance[adjs[i]]) {
        			hole_distance[adjs[i]] = curr_distance+1;
        			queue.offer(adjs[i]);
            	}
        	}
        }
        
//        show(hole_distance);
        
        int mouse_node = 1, cat_node = 2;
        int mouse_pre_step1 = -1, mouse_pre_step2 = -1, cat_pre_step1 = -1, cat_pre_step2 = -1;
        while(true) {
        	// mouse turn
        	int[] mouse_adjs = graph[mouse_node];
        	int min_node = -1, min_distance = Integer.MAX_VALUE;
        	for(int i = 0; i < mouse_adjs.length; i++) {
        		if(mouse_adjs[i] == 0) {
        			return 1;
        		}
        		else if(mouse_adjs[i] != cat_node) {
        			int[] adj_neighbor = graph[mouse_adjs[i]];
        			boolean isCat = false;
        			for(int j = 0; j < adj_neighbor.length; j++) {
        				if(adj_neighbor[j] == cat_node) {
        					isCat = true;
        					break;
        				}
        			}
        			if(!isCat && hole_distance[mouse_adjs[i]] < min_distance) {
        				min_node = mouse_adjs[i];
        				min_distance = hole_distance[min_node];
        			}
        		}
        	}
        	if(min_node == -1) {	// no node can go
    			return 2;
        	}
        	else {
        		mouse_node = min_node;
        	}
        	
        	// cat turn
        	int[] cat_adjs = graph[cat_node];
        	min_node = -1;
        	min_distance = Integer.MAX_VALUE;
        	for(int i = 0; i < cat_adjs.length; i++) {
        		int distance = hole_distance[cat_adjs[i]];
        		if(distance < hole_distance[mouse_node] && distance < min_distance && distance != 0) {
        			min_node = cat_adjs[i];
        			min_distance = distance;
        		}
        	}
        	if(min_node == -1) {
    			return 1;
        	}
        	else {
        		cat_node = min_node;
        	}
        	
        	// draw
        	if(mouse_node == mouse_pre_step2 && cat_node == cat_pre_step2) {
    			return 0;
        	}
        	mouse_pre_step2 = mouse_pre_step1;
            mouse_pre_step1 = mouse_node;
            cat_pre_step2 = cat_pre_step1;
            cat_pre_step1 = cat_node;
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
