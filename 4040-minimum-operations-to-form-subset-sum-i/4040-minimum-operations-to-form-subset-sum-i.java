class Solution {
    public int minOperations(int[] nums, int sum) {
        int [] dp=new int[sum+1];
        Arrays.fill(dp,(int)1e6);
        dp[0]=0; // base case agr sum=0 hai toh koe operations nahi
        for(int op:nums){
            int cpdp []=dp.clone();

            int curr=op;
            for(int i=0; curr<=sum;i++){
                for(int j=0; j+curr<=sum;j++){
                    cpdp[j+curr]=Math.min(dp[j]+i,cpdp[j+curr]);
                }
                curr=curr*2;
            }
            curr=op;
            for(int i=0; curr>0;i++){
                for(int j=0; j+curr<=sum;j++){
                    cpdp[j+curr]=Math.min(dp[j]+i,cpdp[j+curr]);
                }
                curr=curr/2;
            }
            dp=cpdp;
        }
        return dp[sum]==1e6?-1:dp[sum];
    }
}