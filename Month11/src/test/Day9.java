/*
 * Best Time to Buy and Sell Stock III My Submissions Question
Total Accepted: 45162 Total Submissions: 182673 Difficulty: Hard
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
每天只能拥有一支股票！！！！！！！
 */

package test;

public class Day9 {
	public static void main(String[] args){
		Day9 d = new Day9();
		int prices[] = {2, 4};
		System.out.println(d.maxProfit(prices));
	}
	
	public int maxProfit(int[] prices) {
		if( prices.length <= 1 )
			return 0;
		int pre[] = new int[prices.length], post[] = new int[prices.length];
        int ans = 0;
        
        int min = prices[0];
        pre[0] = 0;
        for( int i = 1; i < prices.length; i++ ){
        	if( prices[i] < min ){
        		min = prices[i];
        		pre[i] = pre[i-1];
        	}else{
        		pre[i] = Math.max(pre[i-1], prices[i]-min);
        	}
        }
        
        int max = prices[prices.length-1];
        post[prices.length-1] = 0;
        for( int i = prices.length-2; i >= 0; i-- ){
        	if( prices[i] > max ){
        		max = prices[i];
        		post[i] = post[i+1];
        	}else{
        		post[i] = Math.max(post[i+1], max - prices[i]);
        	}
        }
        
        for( int i = 1; i <= prices.length-1; i++ ){
        	if( pre[i] + post[i] > ans )
        		ans = pre[i] + post[i];
        }
        return ans;
    }
	
	
}
