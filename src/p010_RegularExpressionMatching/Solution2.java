package p010_RegularExpressionMatching;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 test = new Solution2();
		
//		String s = "aa";
//		String p = "a";
		
//		String s = "aa";
//		String p = "a*";

//		String s = "ab";
//		String p = ".*";
		
//		String s = "aab";
//		String p = "c*a*b";
		
//		String s = "mississippi";
//		String p = "mis*is*p*.";
		
//		String s = "ababaaabcacbaaa";
//		String p = "ab.*a*b..*b.*..a";
		
//		String s = "abbcbba";
//		String p = "a*bcb*.*";
		
		String s = "";
		String p = "..*.*.*.*.*.*";
		
		boolean ans = test.isMatch(s, p);
		System.out.println(ans);
	}
	
    public boolean isMatch(String s, String p) {
    	Stack stack = new Stack(p.length());
    	s = s+"$";
    	p = p+"$";
    	int s_len = s.length()-1;
    	int p_len = p.length()-1;
    	
    	if(s_len == 0 && p_len == 0) {
    		return true;
    	}
    	
//    	System.out.println(s);
//    	System.out.println(p);
    	
    	int s_index = -1, p_index = -1, regx_index = 0;
    	String[] regx_blocks = new String[p_len+1];
    	
    	while(true) {
    		if(p.charAt(p_index+1) != '$') {
    			if(p.charAt(p_index+2) == '*') {
    				regx_blocks[regx_index++] = p.charAt(p_index+1)+"*";
    				p_index += 2;
    			}
    			else {
    				regx_blocks[regx_index++] = String.valueOf(p.charAt(p_index+1));
    				p_index += 1;
    			}
    		}
    		else {
    			regx_blocks[regx_index++] = "$";
    			break;
    		}
    	}
//    	System.out.println(s);
//    	System.out.println(p);
//    	System.out.println(regx_index);
//    	for(int i = 0; i < regx_index; i++) {
//    		System.out.println("i="+i+", regx="+regx_blocks[i]);
//    	}
    	
    	String regx = regx_blocks[stack.getTop()+1];
    	if(regx.length() == 1 && s_len == 0) {
    		return false;
    	}
    	
    	
		if(regx.charAt(0) != '.' && regx.length() == 1) {	// a
			if(regx.charAt(0) == s.charAt(s_index+1)) {		// string equals to pattern
				stack.push(regx, 1);
				s_index += 1;
			}
		}
		else if(regx.charAt(0) != '.' && regx.length() == 2) {	// a*
			stack.push(regx, 0);
		}
		else if(regx.charAt(0) == '.' && regx.length() == 1) {	// .
			stack.push(regx, 1);
			s_index += 1;
		}
		else {	// .*
			stack.push(regx, 0);
		}
		
    	while(!stack.isEmpty()) {
    		
//    		System.out.println("s_index="+s_index+", stack.getTop()+1="+(stack.getTop()+1));
    		
    		boolean isNotMatch = false;
    		
    		regx = regx_blocks[stack.getTop()+1];
			
    		if(regx == "$" && s.charAt(s_index+1) == '$') {
    			return true;
    		}

    		
    		if(regx == "$") {
    			isNotMatch = true;
    		}
    		else if(regx.charAt(0) != '.' && regx.length() == 1) {	// a
    			if(regx.charAt(0) == s.charAt(s_index+1)) {		// string equals to pattern
    				stack.push(regx, 1);
    				s_index += 1;
    			}
    			else {
    				isNotMatch = true;
    			}
    		}
    		else if(regx.charAt(0) != '.' && regx.length() == 2) {	// a*
    			stack.push(regx, 0);
    		}
    		else if(regx.charAt(0) == '.' && regx.length() == 1) {	// .
    			if(s.charAt(s_index+1) != '$') {
    				stack.push(regx, 1);
    				s_index += 1;
        		}
    			else {
    				isNotMatch = true;
    			}
    		}
    		else {	// .*
    			stack.push(regx, 0);
    		}
    		
    		if(isNotMatch) {
    			while(!stack.isEmpty()) {
    				Data popData = stack.pop();
    				regx = popData.regx;
    				int delta = popData.delta;
    				s_index -= delta;
    				
    				if(regx.charAt(0) != '.' && regx.length() == 2) {	// a*
    					if(s_index+delta+1 < s_len && s.charAt(s_index+delta+1) == regx.charAt(0)) {
    						stack.push(regx, delta+1);
    						s_index += delta+1;
    						break;
    					}
    				}
    				else if(regx.charAt(0) == '.' && regx.length() == 2) {	// .*
    					if(s_index+delta+1 < s_len) {
    						stack.push(regx, delta+1);
    						s_index += delta+1;
    						break;
    					}
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    
    
    class Data {
    	public String regx;
    	public int delta;
    }
    
    class Stack {
    	private Data[] data;
    	private int maxSize;
    	private int top;
    	
    	public Stack(int len) {
    		maxSize = len;
    		data = new Data[maxSize];
    		for(int i = 0; i < maxSize; i++) {
    			data[i] = new Data();
    		}
    		top = -1;
		}
    	
    	public boolean isFull() {
    		if(top == maxSize - 1) return true;
    		else return false;
    	}
    	
    	public boolean isEmpty() {
    		if(top == -1) return true;
    		else return false;
    	}
    	
    	public void push(String regx, int delta) {
    		if(isFull()) {
    			System.out.println("Stack is full!");
    			return;
    		}
    		else {
    			
    			// DEBUG
//    			System.out.println("push "+regx+" and "+delta);
    			
    			data[++top].regx = regx;
    			data[top].delta = delta;
    		}
    		return;
    	}
    	
    	public Data pop() {
    		if(isEmpty()) {
    			System.out.println("Stack is empty!");
    			return null;
    		}
    		else {
    			
    			// DEBUG
//    			System.out.println("pop "+data[top].regx+" and "+data[top].delta);
    			
    			return data[top--];
    		}
    	}
    	
    	public int getTop() {
    		return top;
    	}
    }
}
