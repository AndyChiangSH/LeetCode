package p006_ZigZagConversion;

public class Solution 
{
	public static void main(String[] args) 
	{
		Solution test = new Solution();
		String s = "A";
		System.out.println(test.convert(s, 2));
	}
	
	public String convert(String s, int numRows) 
	{
        char[] ans = new char[s.length()];	// create a array to store the zigzag string
        int first = (numRows-1)*2, second = 0, k = 0;
        
        for(int i = 0; i < numRows; i++)	// run numRows rows
        {
        	int index = i;
        	if(i == 0 || i == numRows-1)	// if it is first row or last row
        	{
        		while(true)
            	{
        			if(index >= s.length() || k >= s.length()) break;	// if index or k out of range, than stop.
            		ans[k++] = s.charAt(index);
            		index += numRows == 1 ? 1 : (numRows-1)*2;	// if numRows is 1, than set first to 1.
            	}
        	}
        	else
        	{
        		while(true)
            	{
        			if(index >= s.length() || k >= s.length()) break;	// if index or k out of range, than stop.
            		ans[k++] = s.charAt(index);
            		index += first;		// move first
            		if(index >= s.length() || k >= s.length()) break;	// if index or k out of range, than stop.
            		ans[k++] = s.charAt(index);	// move second
            		index += second;
            	}
        	}
        	
        	first -= 2;		// before we change rows, first minus 2 and second plus 2.
        	second += 2;
        }
        
        return String.valueOf(ans);		// return ans string
    }
}
