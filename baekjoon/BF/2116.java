package bf;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2116 {

	static int N;
	static int[][] arr;
	static int[] relation = {5,3,4,1,2,0}; // 인덱스를 활용한 접혔을 때의 각 면들의 관계 (0 : 5, 1 : 3, 2 : 4, 3 : 1, 4 : 2, 5 : 0)
	static int[] cube_sum; // 합계를 계산하기 위한 배열
	static int result; // 최종 정답
	
	public static void solve(int n,int cur) {
		
		if(n==N) { // 주사위를 모두 쌓았을 경우 합을 계산하고 result를 갱신
			int tmp = Arrays.stream(cube_sum).sum();
			result = tmp > result ? tmp : result;
			return;
		}
		
		for(int i=0;i<6;i++) {
			if(arr[n][i]==arr[n-1][relation[cur]]) { // 현재 bottom == 이전 top 이면 answer에 최댓값 넣고 다음 solve를 호출
				for(int j=6;j>=1;j--) {
					if(arr[n][i]==j || arr[n][relation[i]]==j)
						continue;
					cube_sum[n]=j;
					break;
				}
				solve(n+1,i); // 다음 주사위  (n+1) 과 현재 아랫면의 인덱스 i를 넘겨줌
				return;
			}
		}
		
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][6];
		cube_sum = new int[N];
		result = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<6;i++) {
			for(int j=6;j>=1;j--) { // 아랫면과 윗면을 제외한 네 면 중 최댓값을 찾는 반복문
				if(arr[0][i]==j || arr[0][relation[i]]==j)
					continue;
				cube_sum[0]=j;
				break;
			}
			solve(1,i); // 다음 주사위 (0+1) 과 현재 아랫면의 인덱스 (i)를 넘겨줌
		}
		System.out.println(result);
		
	}
	
}
