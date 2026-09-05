class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int [] pre=new int[nums.length];
        int [] suff=new int[nums.length];
        pre[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            pre[i]=Math.max(pre[i-1],nums[i]);
        }
        suff[n-1]=nums[n-1];
        for(int i=nums.length-2; i>=0; i--){
             suff[i]=Math.min(suff[i+1],nums[i]);
        }
        for(int i=0; i<nums.length; i++){
            if(pre[i]-suff[i]<=k){
                return i;
            }
        }
        return -1;
    }
}