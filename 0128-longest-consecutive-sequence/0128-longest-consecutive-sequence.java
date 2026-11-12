class Solution {
    public int longestConsecutive(int[] nums) {
       Arrays.sort(nums);
       int cnt=1, max=0;
       int lastSaw=Integer.MIN_VALUE;
       for(int i=0; i<nums.length; i++){
            if(lastSaw==nums[i]-1){
                cnt++;
            }
            else if(nums[i]!=lastSaw){ // consecutive equal wala case
                cnt=1;
            }
            lastSaw=nums[i];
            max=Math.max(max,cnt);
       } 
       return max;
    }
}