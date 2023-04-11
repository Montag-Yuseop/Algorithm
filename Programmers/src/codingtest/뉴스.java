package codingtest;

import java.util.Arrays;
import java.util.HashMap;

public class 뉴스 {
	public static void main(String[] args) {
		
		
		String s = "abc";
		
		System.out.println(s.substring(1, 3));
		
		for(int i = 0; i < s.length()-1; i++) {
			String b = s.substring(i, i+1);
			System.out.println(b);
		}
		
		String[] sarr = {"ab", "bc", "cd", null};
		
		HashMap<String, Integer> hashmap1 = new HashMap<>();
        HashMap<String, Integer> hashmap2 = new HashMap<>();
		
        hashmap1.put("ab", 1);
        hashmap1.put("ab2", 2);
        hashmap1.put("ab3", 3);
        
        System.out.println(Arrays.toString(sarr));
        
        for(int i = 0; i < sarr.length; i++) {
        	if(sarr == null) continue;
        	System.out.println(sarr[i]);
        }
        int min = 0;
        for(int v : hashmap1.values()) {
        	min += v;
        }
        
       int x = (2/3) * 65536;
       System.out.println(x);
       
	}

}
