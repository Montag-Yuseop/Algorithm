package implementation;

import java.util.Scanner;

public class _2920_음계 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[8];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int flag = 0;
		
		for(int i=0; i<7; i++) {
			if(arr[0] == 1 && arr[i+1]-1 == arr[i]) {
				flag++;
			} else if(arr[0]==8 && arr[i+1]+1 == arr[i]) {
				flag--;
			}
		}
		
		if(flag == 7) System.out.println("ascending");
		else if(flag == -7) System.out.println("descending");
		else System.out.println("mixed");
		
	}
}
