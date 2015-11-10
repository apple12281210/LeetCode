package test;

public class Day6 {
	public static void main(String[] args){
		Day6 d = new Day6();
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(d.maxSubArray(nums));
	}
	
	public int maxSubArray(int[] nums) {
        int res = 0, max = Integer.MIN_VALUE;
        for( int i = 0; i < nums.length; i++ ){
        	res += nums[i];
        	max = Math.max(res, max);
        	if( res < 0 ){
        		res = 0;
        	}
        }
        return max;
    }
}
