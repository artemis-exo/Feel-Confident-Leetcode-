// MEMOIZATION 
class Solution {
    int dp[][];
    public int maxSelectedElements(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        dp=new int [n+1][2];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        int max=1;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max, Math.max(Increament(i,0,nums), Increament(i,1,nums)));
        }
        return max;
    }
    public int Increament(int i, int incre, int [] nums){
        if(dp[i][incre]!=-1){
            return dp[i][incre];  
        }
        int current=nums[i]+incre;   // incre -- > 0/1
        int len=1;
        
        // 1 Case -- >> LowerBound(current+1) -- > ex 1 --> 2 
        int j=LowerBound(nums,i+1,current+1);
        if(j!=-1){
           len=Math.max(len,1+Increament(j,0,nums));
        }
         // 2 Case -- >> LowerBound(current) -- > ex 1 --> 1 
         j=LowerBound(nums,i+1,current);
        if(j!=-1){
           len=Math.max(len,1+Increament(j,1,nums)); 
        }
        return dp[i][incre]=len;
    }
    public int LowerBound(int [] nums, int low, int target){
        int high=nums.length;
        // int ans=-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                // ans=mid;
                high=mid;
            }
            else{
                low=mid+1;
            }
        }

        if (low == nums.length || nums[low] != target) {
        return -1;
    }
        return low;
    }
}