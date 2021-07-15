package p049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String[] strs = {""};
		ArrayList<ArrayList<String>> ans = sol.groupAnagrams(strs);
		sol.show(ans);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            int value = calcStringValue(strs[i]);
            
            if (map.containsKey(value)) {
                map.get(value).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(value, list);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            result.add(map.get(key));
        }
        
        return result;
    }
    
    private int calcStringValue(String str) {
        int sum = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sum += pow5(c);
        }
        
        return sum;
    }
    
    private int pow5(char c) {
        int val = c - 'A';
        return val * val * val * val * val;
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
