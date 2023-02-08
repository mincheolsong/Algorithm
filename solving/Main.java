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
		point = new int[M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if(i-1>=0 && j-1>=0)
					arr[i][j] += arr[i][j-1]+arr[i-1][j]-arr[i-1][j-1] + Integer.parseInt(st.nextToken());
				else if(i==0) {
					arr[i][j] += arr[i][j-1];
				}else if(j==0) {
					arr[i][j] += arr[i-1][j];
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++)
				point[i] = Integer.parseInt(st.nextToken());
			
			solve();
		}
		
		
		
		
		
	}

}
