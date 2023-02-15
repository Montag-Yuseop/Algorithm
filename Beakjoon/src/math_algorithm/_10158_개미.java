package math_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10158_개미 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 격자의 크기를 정하기 위한
		int w = Integer.parseInt(st.nextToken()); // 세로 길이
		int h = Integer.parseInt(st.nextToken()); // 가로 높이
		
		int[][] map = new int[h][w]; // h열 w행의 맵 생성
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken()); // 개미의 x좌표
		int y = Integer.parseInt(st.nextToken()); // 개미의 y좌표
		
		int T = Integer.parseInt(br.readLine());
		
		// 델타배열 생성 우상 좌상 좌하 우하
		int[] dr = {-1, -1, 1, 1};
		int[] dc = {1 -1, -1, 1};
		
		int t = 1; // t는 개미가 움직인 시간
		
		int d = 0; // 우상 좌상 좌하 우하 순으로 델타배열의 인덱스를 나타내줄
		
		// 개미가 이동
		while(true) {
			if()
			
			// T시간까지 이동하면 멈춰야함(ex. 8초까지 이동이면 총 8회 이동)
			
			if(T == t) {
				System.out.println(x + " " + y);
				break;
			}

			
		}
		
		
	}

}
