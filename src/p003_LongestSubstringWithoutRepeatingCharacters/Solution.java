package p003_LongestSubstringWithoutRepeatingCharacters;

import java.util.*;

public class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
    	// the idea is like a queue, right is rear and left is front
        int left = 0, right = 0, res = 0;
        Set<Character> set = new HashSet<>();
        
        while(right < s.length()) 
        {
            char c = s.charAt(right++);	// right going forward
            if(!set.add(c)) // if this char appear in hashset, it repeating.
            {
                while(s.charAt(left) != c) // So, the left going forward to the last time of this char.
                {
                    set.remove(s.charAt(left++));
                }
                left++;
            }
            res = Math.max(res, set.size());	// the queue size is the seq length, get the max value.
        }
        
        return res;
    }
}