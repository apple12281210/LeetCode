/*
 * Best Time to Buy and Sell Stock My Submissions Question  --- 1
Total Accepted: 72697 Total Submissions: 214417 Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Subscribe to see which companies asked this question
 */
package test;

public class Day7 {
	public static void main(String[] args){
		Day7 d = new Day7();
		int prices[] = {1};
		System.out.println(d.maxProfit(prices));
	}
	
	public int maxProfit(int[] prices) {
		if( prices.length == 0 ){
			return 0;
		}
		int res = 0, min = prices[0];
		for( int i = 1; i < prices.length; i++ ){
			if( prices[i] < min ){
				min = prices[i];
			}else{
				res = Math.max(res, prices[i]-min);
			}
		}
		return res;
    }
}
