class Solution {
    public int jump(int[] nums) {
        int r=0, l=0, jumps=0;
        int far=0;
        while(r<nums.length-1){
           far=0;
           for(int i=l; i<=r;i++){
            far=Math.max(far,i+nums[i]);
           }
           jumps++;
           l=r+1;
           r=far;

        }
        return jumps;
    }
}