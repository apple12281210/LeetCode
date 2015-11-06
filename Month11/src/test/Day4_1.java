package test;
//��֦���ԣ�DFS+����¼
//1. count[i][deep]ʹ�ñ���¼����
//2. �ӳ�����ʼ����������Ҫ����̵ķָ���ǿ϶���Ҫ���ȿ�����Ļ����Ӵ�����֮ǰ�ı������Ǵ���̵Ļ����Ӵ���ʼ��������������ǵ��¼�֦�������ԭ��
//3. �����ǰ�ķָ�ĸ����Ѿ����ڵ�ǰ���Ž⣬������ֹͣ�Ը�·��������
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
		//1. ����¼
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
				if( dp[begin][i] == 1 && mind > d ){ //3. ��֦
					System.out.println(begin + " " + i);
					d++;
					DFS(s, d, i+1);
					d--;
				}
			}
		}
	}
	/*
	 * ����Ҫend��������Ϊ��߽�����s.length()-1
	 * 
	public void DFS(String s, int d, int begin, int end ){
		//1. ����¼
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
				if( dp[begin][i] == 1 && mind > d ){ //3. ��֦
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
