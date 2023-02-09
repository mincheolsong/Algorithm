package com.mincheolsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] chk;
	static int answer=Integer.MAX_VALUE;
	
	static void cook(int cnt,int sour,int bitter) {
		
		if(cnt==N) {
			if(sour!=1 && bitter!=0) {
				answer = (answer > Math.abs(sour-bitter)) ? Math.abs(sour-bitter) : answer;
				//System.out.println(answer);
			}
			return;
		}
		
		cook(cnt+1,sour*arr[cnt][0],bitter+arr[cnt][1]);
		
		cook(cnt+1,sour,bitter);	
			
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		chk = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		if(N==1) {
			answer = Math.abs(arr[0][0]-arr[0][1]);
		}else {
			cook(0,1,0);
		}
		
		System.out.println(answer);
	}

}
