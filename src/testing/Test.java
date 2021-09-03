package testing;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		int len = 7;
		
		for(int i = 1; i < len; i++) {
        	for(int j = 0; j < len-i; j++) {
        		System.out.println("["+(j)+", "+(j+i)+"]：");
        		for(int k = 0; k < i; k++) {
        			System.out.println("(["+(j)+", "+(j+k)+"], ["+(j+k+1)+", "+(j+i)+"])");
        		}
        		System.out.println("----------------------");
        	}
        }
	}
}
