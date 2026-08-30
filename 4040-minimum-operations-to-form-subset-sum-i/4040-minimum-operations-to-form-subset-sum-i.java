// ** MEMOIZATION  ---> 0/1 Knapsack

class Solution {
    int [][] dp;
    int min=(int)1e7;
    public int minOperations(int[] nums, int sum) {
        int n=nums.length;
        dp=new int[n][sum+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        int ans=Ops(nums,0,sum);
        return Ops(nums,0,sum)>=min?-1 :ans;
    }
    public int Ops(int nums[] , int idx, int sum){
        if(sum==0){
            return 0;
        }
        if(idx==nums.length){
            return min;
        }
        if(dp[idx][sum]!=-1){
            return dp[idx][sum];
        }
        int cnt=Ops(nums,idx+1,sum);

        int x=nums[idx];
        int task=x;
        int cost=0;
        while(task>0 && task <=sum){
            int nxt=Ops(nums,idx+1,sum-task);
            if(nxt!=min){
                cnt=Math.min(cnt,cost+nxt);
            }
            task=task*2;
            cost++;
        }
        task=x/2;
         cost=1;
        while(task>0){
            if(task<=sum){
                int nxt=Ops(nums,idx+1,sum-task);
                if(nxt!=min){
                    cnt=Math.min(cnt,cost+nxt);
                }
            }
            task=task/2;
            cost++;
        }
        return dp[idx][sum]=cnt;
    }
}
 // *** SPACE OPTIMIZATION TO 1D DP
class Solution {
    public int minOperations(int[] nums, int sum) {
        int [] dp=new int[sum+1];
        Arrays.fill(dp,(int)1e6);
        dp[0]=0; // base case agr sum=0 hai toh koe operations nahi
        for(int op:nums){
            int cpdp []=dp.clone(); //fresh current dp ka clone krte hai takki next elemnets ke liye operations krne mey ease anf for copy issliye bnate hai takki ek hi num(op) ko ek hi leep mey baar use na karein

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
            dp=cpdp; // sare updates daal diye 
        }
        return dp[sum]==1e6?-1:dp[sum];
    }
}
