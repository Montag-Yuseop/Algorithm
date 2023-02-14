package im;

import java.util.Arrays;
import java.util.Scanner;

public class _1208_Flatten {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int tc = 1; tc<11; tc++) {
			int[][] box = new int[100][100];
			
			int dump = sc.nextInt();
			
			for(int c = 0; c < 100; c++) {
				int a = sc.nextInt();
				for(int r = 0; r < a; r++) {
					box[r][c] = 1;
				}
			}
			
			for(int i = 0; i<box.length; i++) {
				System.out.println(Arrays.toString(box[i]));
			}
			
			
		}
		
	}
}
