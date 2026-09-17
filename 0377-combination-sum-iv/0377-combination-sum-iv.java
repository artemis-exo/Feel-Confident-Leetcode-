// --- >. ** MEMOIZATION
/*
-----  >>  Yeh same coin change 2 ki trh hai par isme hum same denomination ke but diff order mey coins ko bnakte hai aur cnt ++ kr skte hai
isme dp[target] is state bhi target hi rahegi kyuki hume idx se mtlb nhi hai ku ki order kuch bhi le skte hai coins ka multiple times
*/
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int [] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return Combine(nums,dp,target);
    }
    public int Combine(int [] nums, int [] dp, int target){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        int pick=0;
        for(int i:nums){
        pick+=Combine(nums,dp,target-i);
        }
        dp[target]=pick;
        return pick;
    }
}