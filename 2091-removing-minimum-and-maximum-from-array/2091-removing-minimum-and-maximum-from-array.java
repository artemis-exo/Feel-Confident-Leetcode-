class Solution {
    public int minimumDeletions(int[] nums) {
        int left=0, right=0;
        int n=nums.length;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[right]){
                 right=i;
            }
            if(nums[i]<nums[left]){
                left=i;
            }
        }
        IO.println(left + " "+right);
        if(left>right){
            int temp=left;
            left=right;
            right=temp;
        }
        int res=(left+1)+(n-right);
        int res1=right+1;
        int res2=n-left;

        return Math.min(Math.min(res,res1),res2);
    }
}