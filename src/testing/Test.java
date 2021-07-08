package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		System.out.println(array.length);
		ArrayList list= new ArrayList();
		Collections.addAll(list, array);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
