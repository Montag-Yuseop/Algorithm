package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1074_Z {
	
	static int N, r, c, cnt;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, N);
		
		cnt = 0;
		
		makeZ(size, r, c);
		System.out.println(cnt);
		
	}

	private static void makeZ(int size, int r, int c) {
		if(size == 1) return;
		
		if(r < size/2 && c < size/2 ) {
			// 좌 상단
			makeZ(size/2, r, c);
		} else if(r < size/2 && c >= size/2) {
			// 우 상단
			cnt += (size*size)/4;
			makeZ(size/2, r, c-size/2);
		} else if(r >= size/2 && c < size/2) {
			cnt += ((size*size)/4)*2;
			makeZ(size/2, r-size/2, c);
		} else {
			cnt += ((size*size)/4)*3;
			makeZ(size/2, r-size/2, c-size/2);
		}
		
		
		
	}

}
