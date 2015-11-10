/*
 * Best Time to Buy and Sell Stock II My Submissions Question
 * Total Accepted: 66199 Total Submissions: 166412 Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Subscribe to see which companies asked this question

结题报告：http://blog.csdn.net/ljiabin/article/details/44900389
 */

package test;

public class Day8 {
	public static void main(String[] args){
		Day8 d = new Day8();
		int prices[] = {2, 4, 6, 1, 7};
		System.out.println(d.maxProfit(prices));
	}
	
	public int maxProfit(int[] prices) {
        int ans = 0;
        for( int i = 1; i < prices.length; i++ ){
        	if( prices[i] - prices[i-1] > 0 )
        		ans += (prices[i] - prices[i-1]);
        }
        return ans;
    }
	
	
}
