//…ÓÀ—æÕ «±©À—£°£°£°

package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Day3 {
	public static void main(String[] args){
		partition("a");
	}
	
	public static int dp[][] = new int[1000][1000];
	
	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> path = new ArrayList<String>();
        
        if( s == null || s.length() == 0 )
        	return res;
        palindrome(s);
        DFS(s, res, path, 0);

        return res;
    }
	
	public static void palindrome( String s ){
		int n = s.length()-1;
		for( int i = 0; i < 1000; i++ ){
			for( int j = 0; j < 1000; j++ ){
				dp[i][j] = -1;
			}
		}
		for( int i = 0; i < n; i++ ){
			dp[i][i] = 1;
			if( s.charAt(i) == s.charAt(i+1) ){
				dp[i][i+1] = 1;
			}
		}
		dp[n][n] = 1;
		for( int i = n; i >= 0; i-- ){
			for( int j = i; j <= n; j++ ){
				if( j <= 0 )
					continue;
				if( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1 ){
					dp[i][j] = 1;
				}
			}
		}
//		for( int i = 0; i <= n; i++ ){
//			for( int j = 0; j <= n; j++ ){
//				if( dp[i][j] == 1 && i != j ){
//					System.out.println(i + " " + j);
//				}
//			}
//		}
	}
	
	public static void DFS( String s, List<List<String>> res, List<String> path, int begin ){
		if( begin == s.length() ){
			List<String> p = new ArrayList<String>(path);
			res.add(p);
//			for( int i = 0; i < path.size(); i++ ){
//        		System.out.print(path.get(i) + ", ");
//        	}
//        	System.out.print("\n");
		}
		for( int j = begin; j < s.length(); j++ ){
			if( dp[begin][j] == 1 ){
				path.add(s.substring(begin, j+1));
				DFS(s, res, path, j+1);
				path.remove(path.size()-1);
			}
		}
	}
}
