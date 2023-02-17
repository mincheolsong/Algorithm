package com.mincheolsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static char[][] map_clone;
    static int answer;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    // 0인 영역 다 클릭

    static int check(int r, int c) { // 8방향 지뢰 갯수 검색
        int count = 0;
        for(int d=0;d<8;d++) {
            if(r+dx[d]>=0 && r+dx[d]<N && c+dy[d]>=0 && c+dy[d]<N) {
                if(map_clone[r+dx[d]][c+dy[d]]=='*')
                    count+=1;
            }
        }
        return count;
    }
    static void bfs(int r,int c) {
        Deque<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(r,c));

        while(queue.size()!=0) {
            Point p = queue.poll();

            int value = check(p.getX(),p.getY());

            if(value==0) {
                map_clone[p.getX()][p.getY()] = (char)(0+'0');
                for(int d=0;d<8;d++) {
                    int nx = p.getX()+dx[d];
                    int ny = p.getY()+dy[d];

                    if(nx<0 || ny<0 || nx>=N || ny>=N || map_clone[nx][ny]!='.') continue;

                    bfs(nx,ny);
                }
            }else {
                map_clone[p.getX()][p.getY()] = (char)(value+'0');
                break;
            }

            for(int d=0;d<8;d+=2) {
                int nx = p.getX()+dx[d];
                int ny = p.getY()+dy[d];

                if(nx<0 || ny<0 || nx>=N || ny>=N || map_clone[nx][ny]!='.') continue;

                queue.offer(new Point(nx,ny));
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;
        int cnt=0;
        for(int t=1;t<=T;t++) {
        	
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];

            for(int i=0;i<N;i++) {
                map[i] = br.readLine().toCharArray();
            }
            
            cnt=0;
            
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    map_clone = map.clone();

                    if(map_clone[i][j]!='.') continue;

                    int result = check(i,j);
                    
                    if(result==0) {
                        map_clone[i][j] = 0;
                        
                        bfs(i,j);
                    }else {
                        map_clone[i][j] = (char)(result+'0');
                    }
                    cnt+=1;
                    System.out.println("Clicked : " + i + ", " + j);

                    for(int k=0;k<N;k++) {
                        System.out.println(Arrays.toString(map_clone[k]));
                    }
                    System.out.println("======= cnt : "+ cnt);
           
                }
	       }
        }

    }

}

class Point {
    private int x,y;
	
	public Point(int x, int y) {
	    this.x = x;
	    this.y = y;
	}
	
	public int getX() {
	    return x;
	}
	
	public void setX(int x) {
	    this.x = x;
	}
	
	public int getY() {
	    return y;
	}
	
	public void setY(int y) {
	    this.y = y;
	}
}