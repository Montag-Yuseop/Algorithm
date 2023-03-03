package im;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _14510_test {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            int[] trees = new int[N];
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[i]);
            }
             
            int ones = 0;
            int twos = 0;
            for (int i = 0; i < N; i++) {
                int diff = max - trees[i];
                ones += diff%2;
                twos += diff/2;
            }
             
            int ans = 0;
            if (ones > twos) ans = 2*ones - 1;
            else {
                int remain = (twos - ones)*2;
                ans = 2*ones + remain/3*2 + remain%3;
            }
            sb.append("#"+t+" "+ans+"\n");
        }
        System.out.println(sb);
    }
}
