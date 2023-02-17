import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1868_파핑파핑지뢰찾기 {
	static int N; // map의 크기가 될 N의 크기 
	static char[][] map; //N*N형태의 지뢰 찾기 게임 상태 받기
	static boolean[][] visited; //방문 확인용
	static int result; //최종 결과(최소 클릭 수)
	
	//8방 탐색을 위한 델타
	static int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};
	
	static Queue<Bomb> queue = new LinkedList<>();
	
	static class Bomb {
		int x;
		int y;
		public Bomb(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb=new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			//N*N 크기의 map 생성, visited 배열 생성
			map = new char[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i<N; i++) {
				//한 행의 string 문자열을 공백 기준으로 쪼개서 1글자 문자형 배열로 반환
				map[i] = br.readLine().toCharArray();
			}
			
			//------------INPUT END-------------
			//전체 맵 클릭해보기
			for(int i=0; i<N;i++) {
				for(int j=0; j<N;j++) {
					
					if(map[i][j] !='.') //지뢰면, 누르면 안되므로 다음으로 넘기기
						continue;
					
					//지뢰가 아닐때~
					int bom = 0;  //지뢰 개수를 셀 변수
					for(int k=0; k<8; k++) { //주변 8방 살펴보기
						int nx = i+dx[k];
						int ny = j+dy[k];
						//경계 체크 후  지뢰있는지 확인
						if(isRange(nx, ny) && map[nx][ny]=='*') {
							bom++;//지뢰 만났으면 지뢰개수 추가
						}
					}
					
					if(bom == 0) { //주변에 하나도 지뢰가 없으면!!!
						queue.add(new Bomb(i,j));
						bfs();
					
					}

				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0;j<N; j++) {
					if(map[i][j]=='.') //바뀌지 않은 .의 개수가 클릭 횟수
						result++;
				}
			}
			
			System.out.printf("#%d %d\n", t, result);
			result = 0;
			
		}

	}
	
	static void bfs() {
		result++; 
		while(!queue.isEmpty()) { //큐가 빌때까지 돌아주기
			Bomb b =queue.poll();//큐에서 값 뽑기
			
			int bom = 0;  //지뢰 개수를 셀 변수
			for(int k=0; k<8; k++) { //주변 8방 살펴보기
				int nx = b.x+dx[k];
				int ny = b.y+dy[k];
				//경계 체크 후  지뢰있는지 확인
				if(isRange(nx, ny) && map[nx][ny]=='*') {
					bom++;//지뢰 만났으면 지뢰개수 추가
				}
			}
			
			if(bom == 0) { //주변에 하나도 지뢰가 없으면!!!
				
				map[b.x][b.y]='x'; //현재 위치는 다른데서 클랙해도 0개 --> 연쇄 작용 일어남
				for(int k=0; k<8; k++) { //주변 8방 살펴보기
					int nx = b.x+dx[k];
					int ny = b.y+dy[k];
					//다음 위치가 경계안에 있고, 지뢰가 아니거나, 방문했던 곳이면 넘기기
					if(!isRange(nx, ny) || map[nx][ny]!='.'||visited[nx][ny]) {
						continue;
					}
					//방문처리
					visited[nx][ny] = true;
					//다음에 이 위치를 탐색할 수 있도록 
					queue.add(new Bomb(nx, ny));
				}
			}else {
				map[b.x][b.y]='x'; 
			}
			
		}

	}
	
	static boolean isRange(int x, int y) {
		if(x<0|| x>=N||y<0||y>=N)
			return false; //경계 넘어가면 안돼요!! false
		return true;//경계 안넘으면 통과! true
	}

}
