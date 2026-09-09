class Solution {
    public long countCommas(long n) {
        long cnt=0;
        for(long i=1000; i<=n;i*=1000){
            cnt+=n-i+1;
            IO.println(cnt);
        }
        return cnt;
    }
}