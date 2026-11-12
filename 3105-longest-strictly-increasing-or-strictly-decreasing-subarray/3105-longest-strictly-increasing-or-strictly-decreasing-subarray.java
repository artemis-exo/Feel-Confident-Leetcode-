// Brute force O(n2)
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max=1;
        for(int i=0; i<nums.length; i++){
            int len=1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j-1]>nums[j]){
                    len++;
                }
                else {
                    break;
                }
            }
            max=Math.max(max,len);
        }
        for(int i=0; i<nums.length; i++){
            int len=1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j-1]<nums[j]){
                    len++;
                }
                else {
                    break;
                }
            }
            max=Math.max(max,len);
        }
        return max;
    }
}