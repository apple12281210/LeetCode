/*
 * Spiral Matrix My Submissions Question
Total Accepted: 44870 Total Submissions: 211483 Difficulty: Medium
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */

package test;

import java.util.*;

public class Test {
	public static void main(String[] args){
		Test d = new Test();
		int m[][] ={{}};
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
        int m = matrix[0].length;
        int n = matrix.length;
        int cnt = 0, basex = 0, basey = 0;
        while(true){
        	int x = directx[cnt], y = directy[cnt];
        	if (n == 0 || m == 0) break;
        	if (n == 1) {
        		ans.addAll(goLine(matrix, basex, basey, directx[0], directy[0], m));
        		break;
        	}
        	if ( m == 1) {
        		ans.addAll(goLine(matrix, basex, basey, directx[1], directy[1], n));
        		break;
        	}
        	ans.addAll(goLine(matrix, basex, basey, directx[0], directy[0], m - 1));
        	ans.addAll(goLine(matrix, basex, basey + m - 1, directx[1], directy[1], n - 1));
        	ans.addAll(goLine(matrix, basex + n - 1, basey + m - 1, directx[2], directy[2], m - 1));
        	ans.addAll(goLine(matrix, basex + n - 1, basey, directx[3], directy[3], n - 1));
        	n -= 2;
        	m -= 2;
        	basex++;
        	basey++;
        	cnt = (cnt + 1) % 4;
        }
        return ans;
    }
	
	public List<Integer> goLine( int[][] m, int startx, int starty, int x, int y, int step ){
		List<Integer> l = new ArrayList<Integer>();
		for( int i = 0; i < step; i++ ){
			l.add(m[startx + x * i][starty + y * i]);
		}
		return l;
	}
}
