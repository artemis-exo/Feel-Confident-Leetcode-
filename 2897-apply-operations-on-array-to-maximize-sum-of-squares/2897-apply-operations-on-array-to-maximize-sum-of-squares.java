class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int bits[]=new int[30];
        long MOD=1000000007;
        long ans=0;
        // Counting the set bits
        for(int i:nums){
            for(int j=0; j<30;j++){
                if((i&(1<<j))!=0)
                bits[j]++;
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