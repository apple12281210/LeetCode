/*
 * Maximum Product Subarray My Submissions Question
Total Accepted: 44161 Total Submissions: 215970 Difficulty: Medium
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Subscribe to see which companies asked this question
 */

package test;

public class Day5 {
	public static void main(String[] args){
		Day5 d = new Day5();
		int nums[] = {-2, -4};
		int ans = d.maxProduct(nums);
		System.out.println(ans);
	}
	
	public int maxProduct(int[] nums) {
        int res = nums[0], max = nums[0], min = nums[0];
        int len = nums.length;
        for( int i = 1; i < len; i++ ){
        	int a = nums[i]*max;
        	int b = nums[i]*min;
        	max = Math.max(Math.max(a, b), nums[i]);
        	min = Math.min(Math.min(a, b), nums[i]);
        	res = Math.max(res, max);
        }
        return res;
    }
}
