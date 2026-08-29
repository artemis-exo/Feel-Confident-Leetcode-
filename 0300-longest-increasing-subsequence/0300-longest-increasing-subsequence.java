// MEMOIZATION --- > prev+1 for AIOB error rescue move
class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
     int n=nums.length;
     dp=new int[n][n+1];
     for(int []i:dp){
        Arrays.fill(i,-1);
     }
     return LIS(0,-1,nums);
        
    }
    public int LIS(int curr, int prev, int [] nums){
        if(curr==nums.length){
            return 0;
        }
        if(dp[curr][prev+1]!=-1){
            return dp[curr][prev+1];
        }
        int take=0;
        if(prev==-1 || nums[curr]>nums[prev]){
            take=1+LIS(curr+1,curr,nums);
        }
        int notTake=0+LIS(curr+1,prev,nums);

        return dp[curr][prev+1]=Math.max(take,notTake);
    }
}

// ** TABULATION
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int curr=n-1;curr>=0; curr--){
           for(int prev=curr-1;prev>=-1;prev--){
            int notTake=0+dp[curr+1][prev+1];

            int take=0;
            if(prev==-1 || nums[curr]>nums[prev]){
                take=1+dp[curr+1][curr+1];
            }
            dp[curr][prev+1]=Math.max(take,notTake);
           } 
        }
        return dp[0][-1+1];
    }
}
