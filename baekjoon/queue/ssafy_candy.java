package com.mincheolsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Deque<Integer> queue = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		
		int candy=20;
		int[] arr = new int[candy];
		int idx=0;
		int cnt=1;
		
		queue.add(1);
		
		while(candy>0) {
			System.out.println(queue);
			idx = queue.pollFirst();
			System.out.println("캔디 " + (arr[idx]+1) + "개 먹음");
			candy-=arr[idx]+1;
			System.out.println("남은 캔디 갯수 : " + candy);
			arr[idx]+=1;
			queue.add(idx);
			cnt+=1;
			queue.add(cnt);
		}
		
		System.out.println(idx);
	}
	
}
