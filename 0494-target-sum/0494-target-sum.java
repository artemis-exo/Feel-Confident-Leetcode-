class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
       int total=0;
       for(int i:nums){
        total+=i;
       } 
       target=Math.abs(target);
       if(target>total || (total-target)%2==1){
        return 0;
       }
       int sum=(total+target)/2;
       int dp[][]=new int[n+1][sum+1];
       for(int i[]:dp){
        Arrays.fill(i,-1);
       }
       return cntSub(n,sum,nums,dp);
    }
    public int cntSub(int i, int sum, int [] nums, int [][]dp){
        if(i==0){
            return sum==0?1:0;
        }
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int take=0;
        if(nums[i-1]<=sum){
            take=cntSub(i-1,sum-nums[i-1],nums,dp);
        }
        int skip=cntSub(i-1,sum,nums,dp);
        return dp[i][sum]=take+skip;
    }
}