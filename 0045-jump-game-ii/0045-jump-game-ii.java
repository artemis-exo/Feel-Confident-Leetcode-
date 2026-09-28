// class Solution {
//     public int jump(int[] nums) {
//         int r=0, l=0, jumps=0;
//         int far=0;
//         while(r<nums.length-1){   // range ka end point
//            far=0;
//            for(int i=l; i<=r;i++){
//             far=Math.max(far,i+nums[i]);  // r ki range set krne ke liye for further jumps
//            }
//            jumps++;
//            l=r+1;
//            r=far;

//         }
//         return jumps;
//     }
// }

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // We no longer need to pass a 'jump' tracker
        return jumpie(0, dp, nums);
    }
    
    public int jumpie(int idx, int[] dp, int[] nums) {
        if (idx >= nums.length - 1) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int minJumps = Integer.MAX_VALUE;
        
        // Try all possible jump lengths from the current index
        for (int i = 1; i <= nums[idx]; i++) {
            int nextJumps = jumpie(idx + i, dp, nums);
            
            // If the end is reachable from the next step, add 1 for the current jump
            if (nextJumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + nextJumps);
            }
        }
        dp[idx] = minJumps;
        return dp[idx];
    }
}