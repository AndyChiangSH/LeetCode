package p049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] strs = {"ate", "tan", "eat", "nat", "bca"};
		sol.groupAnagrams(strs);
	}
	
	public ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		int len = strs.length;
        if(len == 0) {
        	return ans;
        }
        if(len == 1) {
        	ArrayList<String> group = new ArrayList<>();
        	group.add(strs[0]);
        	ans.add(group);
        	return ans;
        }
        
        String[] copied = Arrays.copyOf(strs, len);
        for(int i = 0; i < len; i++) {
        	char[] ca = strs[i].toCharArray();
        	Arrays.sort(ca);
        	strs[i] = new String(ca);
        }
        show(strs);
        
        int index = 0;
        Hashtable<String, Integer> table = new Hashtable<>();
        for(int i = 0; i < len; i++) {
        	String key = strs[i];
        	System.out.println("key = "+key+", index = "+table.get(key));
        	if(table.get(key) != null) {
        		ans.get(table.get(key)).add(copied[i]);
        	}
        	else {
        		table.put(key, index);
        		ArrayList<String> group = new ArrayList<>();
            	group.add(copied[i]);
            	ans.add(group);
        		index++;
        	}
        }
        show(ans);
        
        return null;
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
