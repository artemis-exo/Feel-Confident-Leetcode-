class Solution {
    public int removeDuplicates(int[] nums) {
        // int start=1, end=nums.length-1;
        // int des=0;
        // while(start<=end){
        //     if(nums[start]!=nums[des]){
        //         des++;
        //         nums[des]=nums[start];

        //     }
        //     start++;
        // }
        // return des+1;
        int i=0, j=1;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                i++;
               nums[i]=nums[j];
               
            }
            j++;
        }
        return i+1;
        
    }
}