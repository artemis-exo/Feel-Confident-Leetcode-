class Solution {
    public int minMoves2(int[] nums) {
        // In this we can Icreament and Decreament Both 
        // So we have take the Median to do the result
        Arrays.sort(nums);
        int median=nums[nums.length/2];
        long moves=0;
        for(int i:nums){
            moves+=Math.abs(i-median);
        }
         return (int)moves;
    }
}