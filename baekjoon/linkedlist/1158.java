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
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> circle = new LinkedList<>();
		
		int N,K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int circle_size=N;
		
		for(int i=1;i<=N;i++) {
			circle.add(i);
		}
		
		int idx=0;
		int remove_cnt=0;
		System.out.print("<");
		while(circle.size()!=1) {
			idx+=K;
			while(idx>circle_size) {
				idx-=circle_size;
				circle_size = circle.size();
				remove_cnt=0;
			}
			System.out.print(circle.get(idx-1-remove_cnt)+", ");
			circle.remove(idx-1-remove_cnt);
			
			remove_cnt+=1;
		}
		if(circle.size()==1)
			System.out.println(circle.get(0) + ">");
		else {
			System.out.println(">");
		}
		
	}
}
