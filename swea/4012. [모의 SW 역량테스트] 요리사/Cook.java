package com.mincheolsong;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cook {

	static int N;
	static int[][] arr;
	static int[] tmp;
	static List<int[]> l;
	static int[] a;
	static int[] b;
	static List<Integer> diff;
	
	static int calcB() {
		int answer=0;
		
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				answer+=arr[b[i]-1][b[j]-1];
			}
		}
		
		for(int i=0;i<a.length-1;i++) { 
			for(int j=i+1;j<a.length;j++) {
				answer+=arr[b[j]-1][b[i]-1]; 
			} 
		}
		 
		
		return answer;
		
	}

	
	static int calcA() {
		int answer=0;
		
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				answer+=arr[a[i]-1][a[j]-1];
			}
		}
		
		
		for(int i=0;i<a.length-1;i++) { 
			for(int j=i+1;j<a.length;j++) {
				answer+=arr[a[j]-1][a[i]-1]; 
			} 
		}
		 
		
		return answer;
		
		
	}

	static void solve() {
		/*
		 * System.out.println(Arrays.toString(a));
		 * System.out.println(Arrays.toString(b)); System.out.println("=====");
		 */
		//a 의 모든 시너지 계산, b의 모든 시너지 계산 후 차이값 누적
	    diff.add(Math.abs(calcA()-calcB()));
	    return;
	}
	
	static void divide(int start, int n) {
	    if(n==N/2) {
	        l.add(tmp.clone());
	        return;
	    }
	    
	    
	    for(int i=start;i<=N;i++) {
	        tmp[n] = i;
	        divide(i+1,n+1);
	    }
	}

public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = null;
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    for(int t=1;t<=T;t++) {
	        N = Integer.parseInt(br.readLine());
	        arr = new int[N][N];
	        tmp = new int[N/2];
	        
	        
			
			  for(int r=0;r<N;r++) { 
				  st = new StringTokenizer(br.readLine()); 
				  for(int c=0;c<N;c++) {
					  arr[r][c]=Integer.parseInt(st.nextToken()); 
				  }
			  }
			 
	        l = new ArrayList<>();
	        divide(1,0);
	        int[][] result = new int[l.size()][N/2];
	        l.toArray(result);
	        
	        diff = new ArrayList<>();
	        
	        for(int i=0;i<result.length/2;i++) {
	            a = result[i];
	            b = result[result.length-i-1];
	            solve();
	        }
	        
	        System.out.printf("#%d %d\n",t,Collections.min(diff));
	        
	        
	        
	        
	        
	    }
        
	}
}
