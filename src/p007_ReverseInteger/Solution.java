package p007_ReverseInteger;

public class Solution 
{
	public static void main(String[] args) 
	{
		int x = -100;
		System.out.println(x);
		Solution test = new Solution();
		System.out.println(test.reverse(x));
	}
	
    public int reverse(int x) 
    {
    	// if x is zero, return 0
    	if(x == 0)
    		return 0;
    	
    	// rev is reverse of x
    	int a = x;
        int rev = 0;
        while(a != 0)
        {
        	rev = rev*10 + a%10;
        	a = a/10;
        }
//        System.out.println("rev = "+rev);
        
        // revx is reverse of rev
        a = rev;
        int revx = 0;
        while(a != 0)
        {
        	revx = revx*10 + a%10;
        	a = a/10;
        }
//        System.out.println("revx = "+revx);
        
        // remove all 0 from right of x
        while(x%10 == 0)
        	x = x/10;
        
//        System.out.println("x = "+x);
        
        // if x is not equal to reverse of reverse of x, return 0
        if(x != revx) return 0;
        return rev;
    }
}
