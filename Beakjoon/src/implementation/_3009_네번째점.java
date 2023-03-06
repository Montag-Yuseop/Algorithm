package implementation;

import java.util.Scanner;

public class _3009_네번째점 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] sq = new int[3][2];
		int x = 0;
		int y = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				sq[i][j] = sc.nextInt();
			}
		}
		// x축 점검
		if (sq[0][0] == sq[1][0]) x = sq[2][0];
		else if(sq[0][0] == sq[2][0]) x = sq[1][0];
		else x = sq[0][0];
			
		// y축 점검
		if (sq[0][1] == sq[1][1]) y = sq[2][1];
		else if(sq[0][1] == sq[2][1]) y = sq[1][1];
		else y = sq[0][1];

		System.out.println(x + " " + y);
		sc.close();
	}

}
