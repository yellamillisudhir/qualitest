package cucumber.test.Helper;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<10; i++) list.add(i);
        Collections.shuffle(list);
        for (int i=0; i<4; i++) 
        System.out.println(list.get(i));
        
        
    }
}
