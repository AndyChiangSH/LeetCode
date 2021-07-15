package p049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Solution5 {
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		String[] strs = {""};
		ArrayList<ArrayList<String>> ans = sol.groupAnagrams(strs);
		sol.show(ans);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> hm = new HashMap<String,List<String>>();
        
        for(int i=0; i<strs.length; i++){
            String eachString = strs[i];
            
            //only lower-case letters. so array of size 26 is enough
            int[] counter = new int[26];
            
            //Iterate the string and increment corresponding index
            //char - 'a' , so the index will be between 0 and 25
            for(int j=0; j<eachString.length(); j++)
                counter[eachString.charAt(j)-'a']++;
            
            //Now iterate thorugh the counter array and construct the hash 
            //Eg: cat becomes 1a1c1t. caabbt becomes 2a2b1c1t
            StringBuilder sb = new StringBuilder("");
            for(int j=0; j<26; j++){
                if(counter[j]>0){
                    sb.append(counter[j]);
                    sb.append((char) ('a'+j));
                }
            }
            
            String hash = sb.toString();
            
            System.out.println(hash);
            
            //Chech if an entry exists in hash table already, else add a new one
            if(!hm.containsKey(hash))
                hm.put(hash,new LinkedList<String>());
                
            //Add this string to the list pointed by hash
            hm.get(hash).add(eachString);
        }
        
        return new LinkedList<List<String>>(hm.values());
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
