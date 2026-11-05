// // Brute Force
// class Solution {
//     public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
//         int cnt=0;
//         for(int i:arr1){
//             boolean flag=true;
//             for(int j:arr2){
//                 if(Math.abs(i-j)<=d){
//                     flag=false;
//                     break;
//                 }
//             }
//             if(flag)
//             cnt++;
//         }
//         return cnt;
//     }
// }

// Optimal Using Binary Search
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt=0;
        for(int i=0; i<arr1.length; i++){
            // lower bound issliye nikal rhe hai takki agr koe bhi element in arr2 agr greater hai arr1[i] se aur greater than d bhi hai toh mtlb bde sare in arr2 bhi bde hi honge no need to check
            int j=lowerBound(arr2,arr1[i]);
            if(j==0){ // sare elements bde hai arr1 ke
              if(arr2[0]-arr1[i]>d)
              cnt++;
            }
            else if(j>=arr2.length){ // all elements are samller than arr1
             if(arr1[i]-arr2[arr2.length-1]>d)
             cnt++;
            }
            else{
                if(arr2[j]-arr1[i]>d && arr1[i]-arr2[j-1]>d)
                cnt++;
            }
        }
        return cnt;
    }
    public int lowerBound(int [] arr, int target){
        int low=0, high=arr.length-1;
    
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}