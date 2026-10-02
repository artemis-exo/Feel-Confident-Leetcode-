class Solution {
    public boolean canJump(int[] nums) {
        Boolean dp[]=new Boolean[nums.length];
        return Jump(0,nums,dp);
    }
    public boolean Jump(int i, int [] nums, Boolean dp[]){
        if(i==nums.length-1){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        for(int j=1;j<=nums[i];j++){
            if(Jump(i+j,nums,dp)){
                return  dp[i]=true;
            }
        }
        return dp[i]=false;
    }
}