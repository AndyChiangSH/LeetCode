package testing;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> a = new ArrayList<Integer>();
		list.add(a);
		System.out.println("size = "+list.size());
		
		for(int i = 0; i < 5; i++) {
			if(list.size() <= 1) {
				List<Integer> b = new ArrayList<Integer>();
				b.add(10);
				list.add(b);
			}
			else {
				list.get(1).add(5);
			}
		}
		
		test.show(list);
		
	}
	
	// show int 2D-arrayList
	private void show(List<List<Integer>> list) {
		System.out.print("[");
		for(int i = 0; i < list.size(); i++) {
			System.out.print("[");
			List a = list.get(i);
			for(int j = 0; j < a.size(); j++) {
				System.out.print(a.get(j));
				if(j != a.size()-1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
			if(i != list.size()-1) {
				System.out.print(",\n ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
