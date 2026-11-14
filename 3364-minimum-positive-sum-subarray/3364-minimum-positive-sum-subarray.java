// class Solution {
//     public int minimumSumSubarray(List<Integer> nums, int l, int r) {
//         int [] pre=new int[nums.size()];
//         pre[0]=nums.get(0);
//         for(int i=1; i<nums.size();i++){
//            pre[i]=pre[i-1]+nums.get(i);
//         }
//         int j=0,i=0;
//         int min =Integer.MAX_VALUE;
//         int sum=0;
//         while(i<nums.size()){
//             if(j>=nums.size()){ // AOB se bchne ke liye J idx ==4 pe jayega toh aur j==3 tak ka check hogya hai toh 
//               // i++ krke age badhao aur j=i krke new window start karo
//                 i++;
//                 j=i;
//                 continue;
//             }
//             int win=j-i+1;
//             if(win>=l && win<=r){
//                 sum=(i==0)?pre[j]:pre[j]-pre[i-1];
//                 if(sum>0){
//                    min=Math.min(min,sum);
//                 }
//                j++; 
//             }
//             else if (win>r){
//                 i++;  // For handling cases like  -- > [-12,8] 
//                 j=i;
//             }
//             else {
//                 j++;
//             }
        
//         }
//        return min==Integer.MAX_VALUE?-1:min;
//     }
// }

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int [] pre=new int[nums.size()];
        pre[0]=nums.get(0);
        for(int i=1; i<nums.size();i++){
           pre[i]=pre[i-1]+nums.get(i);
        }
          int ans = Integer.MAX_VALUE;

        for(int i=0; i<nums.size(); i++){
            for(int j=l;j<=r; j++){
                int len=j+i-1;

                if(len>pre.length-1){
                    break;
                }
                int sum=(i==0)?pre[len]:pre[len]-pre[i-1];
                if(sum>0){
                    ans=Math.min(ans,sum);
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}