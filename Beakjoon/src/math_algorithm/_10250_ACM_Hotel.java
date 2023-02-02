package math_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10250_ACM_Hotel {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int tc = 0; tc < T; tc++) {

			String s = bf.readLine();

			StringTokenizer st = new StringTokenizer(s);

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());


			
			int h = 0;
			int w = 0;
			
			if(H >= N) {
				h = N;
				w = 1;
			} else {
				
				w = N/H + 1;
				h = N%H;
				
				if(h==0) {
					h = H;
					w = N/H;
				}
			}
			

			System.out.printf("%d%02d", h, w);
			System.out.println();

		}
	}

}
