package com.mincheolsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static Deque<String> queue;
	static String st;
	
	static int solve() {
		queue = new ArrayDeque<>();
		
		for(char ch : st.toCharArray()) {
			if(ch=='(' || ch=='{' || ch=='<' || ch=='[') {
				queue.add(ch+"");
			}else if(ch==')') {
				String tmp = queue.pollLast();
				if(!tmp.equals("(")) {
					return 0;
				}
			}else if(ch=='}') {
				String tmp = queue.pollLast();
				if(!tmp.equals("{")) {
					return 0;
				}
			}else if(ch=='>') {
				String tmp = queue.pollLast();
				if(!tmp.equals("<")) {
					return 0;
				}
			}else if(ch==']') {
				String tmp = queue.pollLast();
				if(!tmp.equals("[")) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0;i<10;i++) {
			int N = Integer.parseInt(br.readLine());
			st = br.readLine();
			
			System.out.printf("#%d %d",(i+1),solve());
		}
	}
	
}
