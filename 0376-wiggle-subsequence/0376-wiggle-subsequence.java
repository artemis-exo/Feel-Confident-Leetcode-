class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2){
            return nums.length; // agar 2 se kam length hai toh iska mtlb 1 toh hoga hi atleast
        }
        int cnt=nums[1]-nums[0]==0?1:2; // agar phele do ka diff 0 ata hai toh means bs 1 hi hoga kyu ki dono same hai
        int prev=nums[1]-nums[0];
        int diff=0;
        int ex=0;
        for(int i=2; i<nums.length; i++){
            ex++;
            diff=nums[i]-nums[i-1];
            if((diff<0 && prev>=0) || (diff>0 && prev<=0)){ // 0 ko bhi positive mey count krenge
                cnt++;
                prev=diff;
                IO.println(cnt);
            }
        }
        return cnt;
    }
}