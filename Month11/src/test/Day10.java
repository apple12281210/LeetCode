/*Best Time to Buy and Sell Stock IV My Submissions Question
Total Accepted: 17236 Total Submissions: 86473 Difficulty: Hard
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


��⣺����
 * local[i][j]:�����i��һ���н��ף������������������diff>0�����൱��i-1�������������Ϊlocal[i-1][j]��
 *                                    ���diff<0�����൱��global[i-1][j-1]+diff,�൱��global[i-1][j-1]
 * global[i][j]:���������ĵ�i�췢��j�ν��׵�������档��Ϊ��i������local[i][j]���i��û������global[i-1][j]��ȡ���ߡ�
 * 
 * ����֪�����������õĶ�ά����������Խ�Ϊһά�ģ���ֻ�ô�СΪk��һά�����¼�����i��ʱ�ľֲ����Ž��ȫ�����Ž⡣
 * ��Ҫע����ǣ����ڵ�i��ʱ����k�ε����Ž������ڵ�i-1��ʱ����k-1�ε����Ž⣬�����������Ӧ���Ӻ���ǰ������k��1�����¡�
 * 
 * 
 * ���䣺����⻹��һ�����壬���ǵ�k��������ʱ����ʵ���˻��� Best Time to Buy and Sell Stock II �ˡ��Ͳ����ö��������ˣ�Ϊʲô������˼����
 *  ���⣬Best Time to Buy and Sell Stock III ���Ǳ���k=2�����������˵IV��II��III���ۺϡ�
 */


package test;

public class Day10 {
	public static void main(String[] args){
		Day10 d = new Day10();
		int prices[] = {5, 6, 7, 3, 5};
		System.out.println(d.maxProfit(3, prices));
	}
	
	public int maxProfit(int k, int[] prices) {
        if( prices.length < 2 )
        	return 0;
        
        int n = prices.length;
        if( k >= n ){
        	return maxProfit2(prices);
        }
        int local[] = new int[k+1];
        int global[] = new int[k+1];
        
        for( int i = 1; i < n; i++ ){
        	int diff = prices[i] - prices[i-1];
        		for( int j = k; j >= 1 ; j-- ){
        		local[j] = Math.max(global[j-1], (local[j] + diff));
        		global[j] = Math.max(global[j], local[j]);
        	}
        }
        return global[k];
    }
	
	public int maxProfit_1(int k, int[] prices) {
        if( prices.length < 2 )
        	return 0;
        
        int n = prices.length;
        if( k >= n ){
        	return maxProfit2(prices);
        }
        int local[][] = new int[n][k+1];
        int global[][] = new int[n][k+1];
        
        for( int i = 1; i < n; i++ ){
        	int diff = prices[i] - prices[i-1];
        		for( int j = 1; j <= k; j++ ){
        		local[i][j] = Math.max(global[i-1][j-1], (local[i-1][j] + diff));
        		global[i][j] = Math.max(global[i-1][j], local[i][j]);
        	}
        }
        return global[n-1][k];
    }
	
	public int maxProfit2( int prices[] ){
		int ans = 0;
		for( int i = 1; i < prices.length; i++ ){
			if( prices[i] - prices[i-1] > 0 )
				ans += (prices[i]-prices[i-1]);
		}
		return ans;
	}
}
