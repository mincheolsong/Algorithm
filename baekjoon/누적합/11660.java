package com.mincheolsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] arr;
	static int[] point;
	
	static void solve() {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		point = new int[4];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if(i-1>=0 && j-1>=0) {
					arr[i][j] = arr[i][j-1]+arr[i-1][j]-arr[i-1][j-1] + Integer.parseInt(st.nextToken());
				}else if(i==0 && j-1>=0) {
					arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
				}else if(i-1 >= 0 && j==0) {
					arr[i][j] = arr[i-1][j] + Integer.parseInt(st.nextToken());
				}
				else {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				point[j] = Integer.parseInt(st.nextToken())-1;
			}
			
			int answer = arr[point[2]][point[3]];
			
			if(point[0]==point[2] && point[1]==point[3]) { // (x1,y1) (x2,y2)가 같은 경우
				if(point[0]-1>=0) {
					answer-=arr[point[0]-1][point[1]];
				}
				if(point[1]-1>=0) {
					answer-=arr[point[0]][point[1]-1];
				}
				if(point[0]-1>=0 && point[1]-1>=0) {
					answer+=arr[point[0]-1][point[1]-1];
				}
			}else {
				if(point[0]-1>=0) {
					answer-=arr[point[0]-1][point[3]];
				}
				if(point[1]-1>=0) {
					answer-=arr[point[2]][point[1]-1];
				}
				if(point[0]-1>=0 && point[1]-1>=0) {
					answer+=arr[point[0]-1][point[1]-1];
				}
			}
			
			System.out.println(answer);
		}
		
	}

}