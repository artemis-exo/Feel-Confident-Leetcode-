class Solution {
    public long gcdSum(int[] nums) {
       int prefixGcd []=new int[nums.length];
       int max=-1;
       for(int i=0;i<nums.length; i++){
        max=Math.max(max,nums[i]);
        prefixGcd[i]=gcd(max,nums[i]);
       } 
       Arrays.sort(prefixGcd);
       int i=0, j=nums.length-1;
       long sum=0;
       while(i<j){
         sum+=gcd(prefixGcd[i],prefixGcd[j]);
         i++;
         j--;
       }
       return sum;
    }
    public int gcd(int a, int b){
       return b==0?a:gcd(b,a%b);
    }
}