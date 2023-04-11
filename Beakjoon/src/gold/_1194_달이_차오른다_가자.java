package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1194_달이_차오른다_가자 {
	
	static class Node {
		int r, c, cnt, key;

		public Node(int r, int c, int cnt, int key) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
		
	}
	
	static int N, M; // 가로와 세로의 크기
	static int ans; // 정답
	static char[][] map;
	static boolean[][][] visited;
	static char[][] inventory;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		// 방문 배열은 열쇠를 먹을 때 마다 초기화 해 줄거야
		// 열쇠는 a ~ f까지 총 6개가 있고, 열쇠를 안먹은 세상이 있으니까 0~6까지 사용할 예정
		// 열쇠를 하나 먹을 때 마다 초기화된 배열을 사용할 예정
		visited = new boolean[N][M][7];
		
		// ans는 최댓값으로 사용할게 > 최소를 찾아야 하니까
		ans = Integer.MAX_VALUE;
		
		// 인벤토리를 생성해서 먹은 키를 저장할 예정입니다만
		// 0 ~ 6번 세상 중에서 열쇠를 먹었으면 해당 인덱스에 저장해주자
		inventory = new char[7][7];
		
		// 배열을 입력
		for(int r = 0; r < N; r++) {
			String s = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
		// 가장 빠르게 답을 찾아야 하는 문제기 때문에 bfs가 어울려보여
		bfs();
		
		// 만일 찾지 못하면 -1, 찾으면 ans를 출력
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
		
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		
		// 시작 위치를 찾아서 노드에 추가합시다
		outer: for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == '0') {
					visited[r][c][0] = true;
					q.offer(new Node(r, c, 1, 0)); // r, c, 이동횟수, 키 보유
					break outer;
				}
			}
		}
		
		out: while(!q.isEmpty()) {
			// 저장된 노드를 빼오고요
			Node curr = q.poll();
			int nowR = curr.r;
			int nowC = curr.c;
			
			// 탈출 지점이 아니라면 4방 탐색을 진행하세요
			for(int d = 0; d < 4; d++) {
				int nr = nowR + dr[d];
				int nc = nowC + dc[d];
				
				// nr, nc가 맵을 넘어가지 않고, 방문한 적 없을 때
				if(bc(nr, nc) && !visited[nr][nc][curr.key]) {
					// 다음 위치가 .이나 0이면? 그냥 노드에 넣고 이동 가능
					if(map[nr][nc] == '.' || map[nr][nc] == '0') {
						visited[nr][nc][curr.key] = true;
						q.offer(new Node(nr, nc, curr.cnt+1, curr.key));
					} 
					
					else if(map[nr][nc] == '#') {
						continue; // 벽이면 그냥 건너뛰삼
					} 
					
					else if(findKey(map[nr][nc])) { // 만약 키를 찾았으면?
						// 일단 그거 현재 세계 + 1 의 인벤토리에 저장해
						// 인벤토리에 없을때만 저장해야겠어
						
						if(!searchInven(map[nr][nc], curr.key)) {
							addInven(map[nr][nc], curr.key+1);
							if(!visited[nr][nc][curr.key+1]) {
								visited[nr][nc][curr.key+1] = true;
								q.offer(new Node(nr, nc, curr.cnt+1, curr.key+1));
							}
						} else {
							q.offer(new Node(nr, nc, curr.cnt+1, curr.key));
						}
						
						// 그리고 세계 하나씩 늘려서 큐에 집어넣어
						// 방문처리도 잊지말고
						
						
					} else if(map[nr][nc] == '1') {
						// 중요한 탈출 지점 확인을 안했네요
						// 만약 다음 지점이 1이면 그냥 cnt+1해주고 나갑시다
						ans = curr.cnt;
						break out;
					} else {
						// 모든 경우 다 해줬으니까 이제 문일 때만 남았겠죠?
						// 문일 때 내 인벤토리를 뒤져서 같은 알파벳의 문이라면 이동합시다
						if(openDoor(nr, nc, curr.key)) {
							visited[nr][nc][curr.key] = true;
							q.offer(new Node(nr, nc, curr.cnt+1, curr.key));
						}
						
					}
				}
			}
		}
	}
	
	private static boolean searchInven(char key, int cnt) {
		
		for(int i = 0; i < 7; i++) {
			if(inventory[cnt][i] == key) return true;
		}
		
		return false;
	}

	private static boolean openDoor(int nr, int nc, int key) {
		// 해당위치의 대문자를 찾고
		// 인벤토리를 뒤져보고
		// 맞으면 열고 갑시다
		
		if(map[nr][nc] == 'A') {
			if(inventory[key][1] == 'a') return true;
		} else if(map[nr][nc] == 'B') {
			if(inventory[key][2] == 'b') return true;
		} else if(map[nr][nc] == 'C') {
			if(inventory[key][3] == 'c') return true;
		} else if(map[nr][nc] == 'D') {
			if(inventory[key][4] == 'd') return true;
		} else if(map[nr][nc] == 'E') {
			if(inventory[key][5] == 'e') return true;
		} else if(map[nr][nc] == 'F') {
			if(inventory[key][6] == 'f') return true;
		}
		return false;
	}

	private static void addInven(char what, int key) {
		
		for(int i = key; i < 7; i++) {
			if(what == 'a') inventory[i][1] = 'a';
			else if(what == 'b') inventory[i][2] = 'b';
			else if(what =='c') inventory[i][3] = 'c';
			else if(what =='d') inventory[i][4] = 'd';
			else if(what =='e') inventory[i][5] = 'e';
			else if(what =='f') inventory[i][6] = 'f';
		}
		
		
	}

	private static boolean findKey(char what) {
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(what == 'a' || what == 'b' || what == 'c' || what == 'd' || what == 'e'|| what == 'f') {
					return true;
				}
			}
		}
		
		return false;
	}

	private static boolean bc(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

}
