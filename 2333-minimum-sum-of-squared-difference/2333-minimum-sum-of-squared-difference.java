class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int diff[]=new int[nums1.length];
        int maxDiff=0;
        for(int i=0; i<nums1.length; i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
            maxDiff=Math.max(maxDiff,diff[i]);
        }
       // IO.println(maxDiff);
        int Diffcnt[]=new int[maxDiff+1];
        for(int i:diff){
            Diffcnt[i]++; // freq count of differences
        }
        long K=(long)k1+k2;
        for(int i=maxDiff; i>0 && K>0;i--){
            int cntOps=(int)Math.min(K,Diffcnt[i]); //Piche se loop kara hai tkki max freq wle elemnent ki freq hi phele kam karein
            Diffcnt[i]=Diffcnt[i]-cntOps;
            Diffcnt[i-1]=Diffcnt[i-1]+cntOps;
            K=K-cntOps;
        }
        long ans=0;
        for(long i=1; i<=maxDiff;i++){
            ans+=Diffcnt[(int)i]*i*i;
        }
        return ans;

    }
}