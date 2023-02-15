package com.mincheolsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] room;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] chk;
	static int count;
	static int[] answer;
	
	static void dfs(int r,int c) {
		
		for(int d=0;d<4;d++) {
			int nr = r+dx[d];
			int nc = c+dy[d];
			if(nr>=0 && nr<N && nc>=0 && nc<N && chk[nr][nc]==false && room[nr][nc]-room[r][c] == 1) {
				chk[nr][nc]=true;
				count+=1;
				dfs(nr,nc);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			chk = new boolean[N][N];
			answer=new int[2];
			answer[1] = Integer.MAX_VALUE;
			
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					room[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					chk[r][c] = true;
					count=1;
					dfs(r,c);
					
					if(count>answer[0]) {
						answer[0]=count;
						answer[1]=room[r][c];
					}
					if(count==answer[0] && room[r][c] < answer[1]) {
						answer[1]=room[r][c];
					}
					
					chk = new boolean[N][N];
					
				}
			}
			System.out.printf("#%d %d %d\n",i,answer[1], answer[0]);
			
			
		}
		
	}
	
}







