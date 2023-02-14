package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _2628_종이자르기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int n = sc.nextInt();
		
		ArrayList<Integer> arrX = new ArrayList<>();
		ArrayList<Integer> arrY = new ArrayList<>();
		
		arrX.add(0);
		arrY.add(0);
		arrX.add(x);
		arrY.add(y);
		
		
		int maxX = 0;
		int maxY = 0;
				
		for(int i = 0; i < n; i ++) {
			int rc = sc.nextInt();
			int cut = sc.nextInt();
			
			if(rc == 0) {
				arrY.add(cut);
			} else {
				arrX.add(cut);
			}
			
		}
		
		Collections.sort(arrX);
		Collections.sort(arrY);
		
		for(int i = 0; i < arrY.size()-1; i++) {
			maxY = Math.max(arrY.get(i+1)-arrY.get(i), maxY);
		}
		
		for(int i = 0; i < arrX.size()-1; i++) {
			maxX = Math.max(arrX.get(i+1)-arrX.get(i), maxX);
		}
		
		System.out.println(maxX * maxY);
	}

}

