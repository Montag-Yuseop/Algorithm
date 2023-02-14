package im;

import java.util.Arrays;
import java.util.Scanner;

public class _1208_Flatten {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc<11; tc++) {
			int[] box = new int[100];
			int dump = sc.nextInt();		
			for(int i = 0; i<100; i++) {
				box[i] = sc.nextInt();
			}
			Arrays.sort(box);
			int cnt = 0;
			for(int i = 0; i<dump; i++) {
				if(box[0] == box[99]) {
					cnt = box[99]-box[0];
					break;
				} else {
					box[0]++;
					box[99]--;
					Arrays.sort(box);
				}
				cnt = box[99]-box[0]; 
			}
			System.out.printf("#%d %d\n",tc , cnt);
		}
		sc.close();
	}
}
