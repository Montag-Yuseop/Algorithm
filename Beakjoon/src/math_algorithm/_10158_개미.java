package math_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10158_개미 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken()); // 세로 길이
		int h = Integer.parseInt(st.nextToken()); // 가로 높이
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken()); // 개미의 x좌표
		int y = Integer.parseInt(st.nextToken()); // 개미의 y좌표
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		sb.append((w - (Math.abs(w-(x+t)%(w*2)))) + " ");
		sb.append(h - (Math.abs(h-(y+t)%(h*2))));
		
		System.out.println(sb);
		
	}

}
