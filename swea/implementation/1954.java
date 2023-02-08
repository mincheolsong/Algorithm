package com.mincheolsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[][] arr;
	static int[][] direction = { // 방향벡터
			{0,1},
			{1,0},
			{0,-1},
			{-1,0}
	};
	
	static void snail(int n) {
		
		int d = 0; // 방향벡터의 인덱스
		int cnt=1; // arr에 1씩 증가시키며 넣을 값
		int row=0, col=0;
		
		while(true) {
			arr[row][col]=cnt++;
			if(cnt>N*N)
				break;
			row+=direction[d%4][0]; // 나머지 연산자를 이용하여 방향벡터를 순회함
			col+=direction[d%4][1];
			if(col>=N || row>=N || col<0 || arr[row][col]!=0) { // 방향이 바뀌는 부분
				row-=direction[d%4][0]; // 증가 시켰던 row와 col의 값을 원상 복구
				col-=direction[d%4][1];
				d+=1; // 방향 벡터의 인덱스를 증가 시킴
				cnt-=1; // cnt 값 또한 원상 복구
			}
			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
			
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			System.out.println("#" + (i+1));
			snail(N);
		}
		
	}

}
