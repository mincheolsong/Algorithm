package com.mincheolsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	Set<Integer> set = new HashSet<>();
    	
    	String[] arr = new String[N];
    	
    	for(int i=0;i<N;i++) {
    		arr[i] = br.readLine();
    	}
    	int length = arr[0].length();

    	for(int i=length-1;i>=0;i--) {
    		for(int j=0;j<N;j++) {
    			set.add(Integer.parseInt(arr[j].substring(i, length)));
    		}
    		
    		
    		if(set.size()==N) {
    			System.out.println(length-i);
    			break;
    		}
    		
    		set.clear();
    		
    	}
    	
    	
    	
    	
    	
    }

}

