package test;

import java.util.*;

public class Day11 {
	public static void main(String[] args){
		Day11 d = new Day11();
		int m[][] ={{1, 2, 3},{ 4, 5, 6}, {7, 8,9}};
		List<Integer> l = d.spiralOrder(m);
		for( int i = 0; i < l.size(); i++ ){
			System.out.print(l.get(i) + ", ");
		}
		System.out.println();
	}
	
	public int directy[] = {1, 0, -1, 0};
	public int directx[] = {0, 1, 0, -1};
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if( matrix.length == 0 ){
        	return ans;
		}
        int n = matrix[0].length;
        int m = matrix.length;
        int stepy = n-1, stepx = m-1, cnt = 0;
        int sx = 0, sy = 0, f = 0, step, flag = 1, init = 0, f11 = 0;
        if( m == 1 ){
        	for( int k = 0; k < n; k++ ){
        		ans.add(matrix[0][k]);
        	}
        	return ans;
        }
        if( n == 1 ){
        	for( int k = 0; k < m; k++ ){
        		ans.add(matrix[k][0]);
        	}
        	return ans;
        }
        if( n <= 2 || m <= 2 ){
        	init = 1;
        }
        while( flag == 1 && (stepx > 0 || stepy > 0) ){
        	cnt = cnt % 4;
        	int x = directx[cnt], y = directy[cnt];
        	System.out.println(stepx + " " + stepy);

        	if( cnt == 0 ){
        		sx = f; sy = f;
        		step = stepy;
        	}else if( cnt == 1 ){
        		sy += stepy;
        		step = stepx;
        	}else if( cnt == 2 ){
        		sx += stepx;
        		step = stepy;
        	}else{
        		sy -= stepy;
        		step = stepx;
            	f++;
            	System.out.println("fff:" + f);
        	}
        	System.out.println(sx + ", " + sy + ", " + x + ", " + y + ", " + step);
        	ans.addAll(goLine( matrix, sx, sy, x, y, step));

        	cnt++;
        }
        return ans;
    }
	
	public List<Integer> goLine( int[][] m, int startx, int starty, int x, int y, int step ){
		List<Integer> l = new ArrayList<Integer>();
		for( int i = 0; i < step; i++ ){
			l.add(m[startx][starty]);
			System.out.println(m[startx][starty]);
			startx += x;
			starty += y;
		}
		return l;
	}
}
