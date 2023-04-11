package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class _5656_벽돌깨기2 {
 
    static int N, W, H, res;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static class State {
        int r, c, cnt;
 
        public State(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
        
    }
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
 
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 쏠 수 있는 구슬 개수
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            int total = 0;    // 전체 벽돌 개수
            int[][] map = new int[H][W];
            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
 
                for (int c = 0; c < W; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if(map[r][c] > 0) total++;
                }
            }
            
            res = Integer.MAX_VALUE;
            process(0, total, map);
 
            System.out.println("#" + tc + " " + res);
        }
 
    }
 
    private static boolean process(int cnt, int remain, int[][] map) {
        
        // 남은 벽돌의 개수 확인
        if(remain == 0) {
            res = 0;
            // 남은 벽돌이 없다면 더이상 확인할 필요가 없으므로 true
            return true;
        }
        // 던질 수 있는 구슬을 모두 던졌을 경우
        if(cnt == N) {
            res = Math.min(res, remain);
            // 다른 경우도 확인해보아야 하므로 false
            return false;
        }
        
        int[][] newMap = new int[H][W];
        // 모든 열에 구슬을 떨어뜨려보자.
        for (int c = 0; c < W; c++) {
            
            int r = 0;
            // 해당 열에서 가장 위에 있는 벽돌의 위치 찾기
            while(r < H && map[r][c] == 0) ++r;
            // 벽돌이 없을 경우 pass
            if(r == H) continue;
 
            // 벽돌이 있을 경우    
            // 이전 구슬의 상태를 복사
            copy(map, newMap);
            // 해당 좌표로 구슬을 떨어뜨려서 벽돌 터뜨리기
            int burstCnt = burst(newMap, r, c);
            // 벽돌 내리기
            down(newMap); 
            // 다음 구슬 처리 (더이상 확인할 필요가 없다면 true)
            if(process(cnt + 1, remain - burstCnt, newMap)) return true;
        }
        
        return false; 
    }
 
    private static void down(int[][] map) {
        
        for (int c = 0; c < W; c++) {
            
            int r = H - 1;
            while(r > 0) {
                // 빈 공간이라면
                if(map[r][c] == 0) {
                    // 직전 행부터 탐색
                    int nr = r - 1;
                    // 처음 만나는 벽돌 찾기
                    while(nr > 0 && map[nr][c] == 0) nr--;
                    
                    map[r][c] = map[nr][c];
                    map[nr][c] = 0;
                }
                
                r--;
            }
        }
        
    }
 
    private static int burst(int[][] map, int r, int c) {
        
        int cnt = 0;
        Queue<State> q = new LinkedList<>();
        // 벽돌의 숫자가 1보다 크면 queue에 추가
        if(map[r][c] > 1) q.add(new State(r, c, map[r][c]));
        // 벽돌이 깨지면 0
        map[r][c] = 0;
        cnt++;
        
        while(!q.isEmpty()) {
            
            State now = q.poll();
                        
            for (int d = 0; d < 4; d++) {
                int rr = now.r;
                int cc = now.c;
                // (벽돌에 적힌 숫자 - 1) 만큼 영향
                for (int k = 0; k < now.cnt - 1; k++) {
                    rr += dr[d];
                    cc += dc[d];
                    // 범위 확인
                    if(rr < 0 || rr >= H || cc < 0 || cc >= W || map[rr][cc] == 0) continue;
                    if(map[rr][cc] > 1) q.add(new State(rr, cc, map[rr][cc]));
                    
                    map[rr][cc] = 0;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
 
    private static void copy(int[][] map, int[][] newMap) {
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        
    }
 
}
