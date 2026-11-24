// BRUTE FORCE ---- >> O(n2logM)
// class Solution {
//     public int maxLength(int[] nums) {
//         int ans=0;
//         for(int i=0; i<nums.length;i++){
//             int prod=nums[i];
//             int GCD=nums[i];
//             int LCM=nums[i];
//             for(int j=i+1;j<nums.length; j++){
//                 prod*=nums[j];
//                 GCD=gcd(GCD,nums[j]);
//                 LCM=(LCM*nums[j])/gcd(LCM,nums[j]);

//                 if(prod==GCD*LCM){
//                     ans=Math.max(ans,j-i+1);
//                 }
//                 if(prod>GCD*LCM)
//                 break;
//             }

//         }
//         return ans; 
//     }
//     public int gcd(int a, int b){
//         return b==0?a:gcd(b,a%b);
//     }
// }

class Solution {
    public int maxLength(int[] nums) {
      int j=0, i=0;
      int ans=2; // BECAUSE of LCM GCD property (a*b)=LCM*GCD --> atleast 2 length ka toh hoga hi
      int prod=1;

      while(j<nums.length){
        while(gcd(prod,nums[j])>1){
            prod=prod/nums[i];
            i++;
        }
        prod*=nums[j];
        ans=Math.max(ans,j-i+1);
        j++;
      }
      return ans;
    }
     public int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}
