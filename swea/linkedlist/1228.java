package com.mincheolsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N;
		
		LinkedList<String> password;
		
		for(int i=0;i<10;i++) {
			N = Integer.parseInt(br.readLine());
			password = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				password.add(st.nextToken());
			}
			
			int command_length = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreElements()) {
				if(st.nextToken().equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					for(int j=0;j<y;j++) {
						password.add(x+j, st.nextToken());
					}
					
				}
			}
			
			System.out.print("#" + (i+1) + " ");
			for(int j=0;j<10;j++) {
				System.out.print(password.get(j) + " ");
			}
			System.out.println();
		}
		
	}
}
