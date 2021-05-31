package p005_LongestPalindromicSubstring;

public class Solution {
	
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = "abaxabxbaxaybaab";
		System.out.println(test.longestPalindrome(s));
	}
	
	public String manacherString(String s)
	{
		char[] c = s.toCharArray();
		char[] res = new char[c.length*2+1];
		int index = 0;
		for(int i=0; i<res.length; i++)
		{
			if(i%2 == 0) res[i] = '#';
			else res[i] = c[index++];
		}
		
		return String.valueOf(res);
	}
	
	public String longestPalindrome(String s) 
	{
		if (s == null || s.length() == 0) {
            return "";
        }
		String ms = manacherString(s);	// generate a new String inserted by #
		int[] p = new int[ms.length()];	// new array to keep LSP value
		int center = -1, right = -1, max = Integer.MIN_VALUE, lps_center = 0;
		
		for(int i=0; i<ms.length(); i++)
		{
			p[i] = right>i ? Math.min(p[2*center-i], right-i) : 1;
			while(i+p[i] < ms.length() && i-p[i] > -1)
			{
				if(ms.charAt(i+p[i]) == ms.charAt(i-p[i])) p[i]++;
				else break;
			}
			
			if(i+p[i] > right)
			{
				right = i+p[i];
				center = i;
			}
			if(p[i] > max)
			{
				max = p[i];
				lps_center = i;
			}
			if(p[i]+i > right)
			{
				right = p[i]+i;
				center = i;
			}
		}
		int start = (lps_center-max+1)/2;
		
		return s.substring(start, start+max-1);
		
    }
}
