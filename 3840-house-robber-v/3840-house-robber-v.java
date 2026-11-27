// MEMOIZATION  

// class Solution {
//     public long rob(int[] nums, int[] colors) {
//         int n=nums.length;
//         long [] dp=new long[n+1];
//         Arrays.fill(dp,-1L);

//         return gain(0,dp,nums,colors);
//     }
//     public long gain(int i, long [] dp, int nums[], int [] colors){
//         if(i>=nums.length){
//             return 0;
//         }
//         if(dp[i]!=-1L){
//             return dp[i];
//         }

//         long skip=gain(i+1,dp,nums,colors);

//         int nextIdx=(i+1<nums.length && colors[i]!=colors[i+1])?i+1:i+2;  // agli idx nikal rha hnu ki agr same nhi hai color toh agle ko lo (i+1) nhi toh agle ko skip krke uska agla lo (i+2)

//         long take=nums[i]+gain(nextIdx,dp,nums,colors);

//         return dp[i]=Math.max(take,skip);

//     }
// }

/// TABULATION

class Solution {
    public long rob(int[] nums, int[] colors) {
        int n=nums.length;
        long [] dp=new long[n+2];
        for(int i=n-1;i>=0;i--){
            long skip=dp[i+1];

            int nextIdx=(i+1<n && colors[i]!=colors[i+1])?i+1:i+2;

            long take=dp[nextIdx]+nums[i];

            dp[i]=Math.max(take,skip);
        }
        return dp[0];
    }
}

