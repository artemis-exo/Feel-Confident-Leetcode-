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
        // IO.println(left + " "+right);
        if(left>right){
            int temp=left;
            left=right;
            right=temp;
        }
        int res=(left+1)+(n-right);  // agr left or right dono alag side exist krte hai
        int res1=right+1;  // agr dono left side exist krte hai
        int res2=n-left;   // if dono right side exist krte hai

        return Math.min(Math.min(res,res1),res2);
    }
}
