package test;
//剪枝策略：DFS+备忘录
//1. count[i][deep]使用备忘录搜索
//2. 从长串开始搜索：问题要求最短的分割，我们肯定需要首先考虑最长的回文子串，而之前的遍历都是从最短的回文子串开始遍历，可能这个是导致剪枝能力差的原因。
//3. 如果当前的分割的个数已经大于当前最优解，则我们停止对该路径的深搜
public class Day4_1 {
	public static void main(String[] args){
		Day4_1 day = new Day4_1();
		System.out.println(day.minCut("aabb"));
	}
	
	public int dp[][] = new int[1000][1000];
	public int count[][] = new int[1000][1000];
	public int deep[] = new int[1000];
	public int mind = inf;
	public static int inf = 10000000;
	
	public int minCut(String s) {		
		palindrome(s);
		for( int i = 0; i < 1000; i++ ){
			for( int j = 0; j < 1000; j++ ){
				count[i][j] = -1;
			}
		}
		
		DFS(s, 0, 0);
		return mind;
    }
	
	public void DFS(String s, int d, int begin ){
		//1. 备忘录
		if( count[begin][d] == 1 )
			return;
		if( s.length() == begin ){
			if( mind > d ){
				mind = d;
				System.out.println("mind:" + mind);
			}
		}else{
			count[begin][d] = 1;
			//2. for( int i = begin; i < s.length(); i++ ){
			//for( int i = s.length()-1; i >= begin; i-- ){
				for( int i = begin; i < s.length(); i++ ){
				if( dp[begin][i] == 1 && mind > d ){ //3. 剪枝
					System.out.println(begin + " " + i);
					d++;
					DFS(s, d, i+1);
					d--;
				}
			}
		}
	}
	/*
	 * 不需要end变量，因为后边界总是s.length()-1
	 * 
	public void DFS(String s, int d, int begin, int end ){
		//1. 备忘录
		if( count[begin][d] == 1 )
			return;
		if( s.length() == begin ){
			if( mind > d ){
				mind = d;
				System.out.println("mind:" + mind);
			}
		}else{
			count[begin][d] = 1;
			//2. for( int i = begin; i < s.length(); i++ ){
			//for( int i = s.length()-1; i >= begin; i-- ){
				for( int i = begin; i <= end; i++ ){
				if( dp[begin][i] == 1 && mind > d ){ //3. 剪枝
					System.out.println(begin + " " + i);
					d++;
					DFS(s, d, i+1, end);
					d--;
				}
			}
		}
	}
	*/
	public void palindrome( String s ){
		for( int i = 0; i < 1000; i++ ){
			for( int j = 0; j < 1000; j++ ){
				dp[i][j] = -1;
			}
		}
		
		for( int i = s.length()-1; i >= 0; i-- ){
			for( int j = i; j < s.length(); j++ ){
				if( j == i ){
					dp[i][j] = 1;
				}else if( j == i+1 && s.charAt(i) == s.charAt(j) ){
						dp[i][j] = 1;
				}else{
					if( j-1 >= 0 && dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j) ){
						dp[i][j] = 1;
					}
				}
			}
		}
	}

}
