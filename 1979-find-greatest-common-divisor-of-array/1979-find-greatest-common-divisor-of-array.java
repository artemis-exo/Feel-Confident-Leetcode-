class Solution {
    public int findGCD(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i:nums){
            if(i>max)
            max=i;
            if(i<min)
            min=i;
        }
        // IO.println(min);
        // IO.println(max);
        return gcd(max,min);
    }
    public int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}
