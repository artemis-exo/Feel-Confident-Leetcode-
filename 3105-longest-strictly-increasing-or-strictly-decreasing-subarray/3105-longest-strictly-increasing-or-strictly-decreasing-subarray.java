// // Brute force O(n2)
// class Solution {
//     public int longestMonotonicSubarray(int[] nums) {
//         int max=1;
//         for(int i=0; i<nums.length; i++){
//             int len=1;
//             for(int j=i+1; j<nums.length; j++){
//                 if(nums[j-1]>nums[j]){
//                     len++;
//                 }
//                 else {
//                     break;
//                 }
//             }
//             max=Math.max(max,len);
//         }
//         for(int i=0; i<nums.length; i++){
//             int len=1;
//             for(int j=i+1; j<nums.length; j++){
//                 if(nums[j-1]<nums[j]){
//                     len++;
//                 }
//                 else {
//                     break;
//                 }
//             }
//             max=Math.max(max,len);
//         }
//         return max;
//     }
// }

// Linear Solution O(N)
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max=1 ,incre=1, decre=1;

        for(int i=1;i<nums.length; i++){
            if(nums[i-1]>nums[i]){
                decre++;
                incre=1;
            }
            else if(nums[i-1]<nums[i]){
                incre++;
                decre=1;
            }
            else{
                incre=1; // agar equal hain toh puarne counter update na ho issliye reset
                decre=1;
            }
            max=Math.max(max,Math.max(incre,decre));
            // max=Math.max(incre,decre);
        }
        return max;
    }
}