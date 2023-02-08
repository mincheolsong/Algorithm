package com.mincheolsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] arr;
	static int sum;
	static int[] selected_arr;
	static int flag=0;
	
	static void solve(int cnt, int current) {
		
		if(cnt==2) {
			if(sum-Arrays.stream(selected_arr).sum()==100) {
				int idx=0;
				for(int j=0;j<9;j++) {
					if(idx<2 && arr[j]==selected_arr[idx]) {
						idx+=1;
					}else {
						System.out.println(arr[j]);
					}
				}
				flag=1;
			}
			return;
		}
		
		
		for(int i=current;i<9;i++) {
			selected_arr[cnt]=arr[i];
			solve(cnt+1,i+1);
			if(flag==1) break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		selected_arr = new int[2];
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sum = Arrays.stream(arr).sum();
		solve(0,0);
		
		
		
	}

}
