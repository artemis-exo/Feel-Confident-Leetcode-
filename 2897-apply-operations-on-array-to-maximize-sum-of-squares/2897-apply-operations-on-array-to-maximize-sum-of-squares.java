class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bits = new int[32];
        int MOD = (int) (1e9 + 7);
        long ans=0;
        for (int num : nums){
            for (int i = 0; i < 32; ++i)
               if ((num & (1 << i)) != 0) {
                 bits[i]++;
                }
        }
        while(k-->0){
            long curr=0;
            for(int i=0; i<30;i++){
                if(bits[i]>0){
                    curr=curr|1L<<i;
                    bits[i]--;
                }
            }
            ans=(ans+(curr*curr))%MOD;
        }
        return (int)ans;

    }
}