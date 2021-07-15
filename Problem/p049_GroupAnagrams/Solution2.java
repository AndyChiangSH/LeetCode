package p049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String[] strs = {""};
		ArrayList<ArrayList<String>> ans = sol.groupAnagrams(strs);
		sol.show(ans);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<>();
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
        
        // copy of string array
        String[] copied = Arrays.copyOf(strs, len);
        // sort each string from a to z, strings in group will be equal
        for(int i = 0; i < len; i++) {
        	char[] ca = strs[i].toCharArray();
        	Arrays.sort(ca);
        	strs[i] = new String(ca);
        }
        
        int index = 0;	// index of array list
        Hashtable<String, Integer> table = new Hashtable<>(); // key is string, value is index of array list
        for(int i = 0; i < len; i++) {
        	String key = strs[i];
        	if(table.get(key) != null) {	// not first time
        		ans.get(table.get(key)).add(copied[i]);
        	}
        	else {	// first time
        		table.put(key, index);
        		ArrayList<String> group = new ArrayList<>();
            	group.add(copied[i]);
            	ans.add(group);
        		index++;
        	}
        }
        
        return ans;
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
