package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] pipe = new int[N];
		int answer=1;
		int pipe_idx=0; // 현재 테이프를 붙인 위치
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pipe[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pipe);
		
		for(int i=0;i<N;i++) { 
			if(pipe[i] >= pipe[pipe_idx]+L) { // 현재 붙인 테이프가 닿지 않을 경우 새로 테이프를 붙임
				answer+=1;
				pipe_idx=i;
			}
		}
		System.out.println(answer);
	}
}
