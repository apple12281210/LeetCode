//http://blog.csdn.net/yutianzuijin/article/details/16850031

package test;
//DP
public class Day4_2 {
	public static void main(String[] args){
		Day4_2 day = new Day4_2();
		System.out.println(day.minCut("abbab"));
	}
	
	public static int inf = 10000000;
	
	public int minCut(String s) {
		int dp[][] = new int[s.length()+1][s.length()+1];
		int deep[] = new int[s.length()+1];
//		for( int i = 0; i <= s.length(); i++ ){
//			deep[i] = inf;
//		}
//		deep[s.length()] = 0;
		for( int i = s.length()-1; i >= 0; i-- ){
			deep[i] = inf;
			for( int j = i; j < s.length(); j++ ){

				if( (j-i < 2 || dp[i+1][j-1] == 1) && s.charAt(i) == s.charAt(j) ){
					dp[i][j] = 1;
					if( deep[j+1] + 1 < deep[i] )
						deep[i] = deep[j+1] + 1;
				}
			}
		}
		return (deep[0]-1);
    }
	
}
