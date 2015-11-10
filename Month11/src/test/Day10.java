/*Best Time to Buy and Sell Stock IV My Submissions Question
Total Accepted: 17236 Total Submissions: 86473 Difficulty: Hard
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


题解：：：
 * local[i][j]:代表第i天一定有交易（卖出）发生。则如果diff>0，则相当于i-1天买进又卖出，为local[i-1][j]，
 *                                    如果diff<0，则相当于global[i-1][j-1]+diff,相当于global[i-1][j-1]
 * global[i][j]:代表真正的第i天发生j次交易的最大利益。则为第i天卖出local[i][j]与第i天没有卖出global[i-1][j]，取大者。
 * 
 * 我们知道，动规所用的二维辅助数组可以降为一维的，即只用大小为k的一维数组记录到达第i天时的局部最优解和全局最优解。
 * 需要注意的是，由于第i天时交易k次的最优解依赖于第i-1天时交易k-1次的最优解，所以数组更新应当从后往前（即从k到1）更新。
 * 
 * 
 * 补充：这道题还有一个陷阱，就是当k大于天数时，其实就退化成 Best Time to Buy and Sell Stock II 了。就不能用动规来做了，为什么？（请思考）
 *  另外，Best Time to Buy and Sell Stock III 就是本题k=2的情况，所以说IV是II和III的综合。
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
