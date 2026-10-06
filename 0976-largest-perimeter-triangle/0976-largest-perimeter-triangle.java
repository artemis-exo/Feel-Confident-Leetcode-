class Solution {
    public int largestPerimeter(int[] nums) {
        // Simple Triangle Property ka use ---- > a+b>c
        // Sort krta hai tkki Large se Large Triangle bna sku
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=2; i--){
           if(nums[i-1]+nums[i-2]>nums[i]){
            return nums[i]+nums[i-1]+nums[i-2];
           }
        }
        return 0;
    }
}