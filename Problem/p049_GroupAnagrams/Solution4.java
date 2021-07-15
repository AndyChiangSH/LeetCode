package p049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Solution4 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		String[] strs = {""};
		ArrayList<ArrayList<String>> ans = sol.groupAnagrams(strs);
		sol.show(ans);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(String w : strs){
            String key = hash(w);          
            if(!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(w);
        }
        
        return new ArrayList<>(map.values());
    }
    
    private String hash(String s){
        int[] a = new int[26];
        for(char c : s.toCharArray()) a[c-'a']++;
        return Arrays.toString(a);
    }
	
	public void show(String[] A) {
		for(int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
	
	public void show(ArrayList<ArrayList<String>> A) {
		for(int i = 0; i < A.size(); i++) {
			ArrayList<String> a = A.get(i);
			for(int j = 0; j < a.size(); j++) {
				System.out.print(a.get(j)+", ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
