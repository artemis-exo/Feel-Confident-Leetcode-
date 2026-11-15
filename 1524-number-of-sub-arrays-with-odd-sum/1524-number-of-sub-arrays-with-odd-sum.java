// Giving TLE due to O(n2) 

// class Solution {
//     public int numOfSubarrays(int[] arr) {
//         int mod=(int)1e9+7;
//         int [] pref=new int[arr.length];
//          pref[0]=arr[0];
//         for(int i=1; i<arr.length; i++){
//             pref[i]=pref[i-1]+arr[i];
//         }
//         int cnt=0;
//         int i=0,j=0;
//         while(i<arr.length){
//             if(j>=arr.length){
//                 i++;
//                 // IO.println("i val"+i);
//                 j=i;
//                 continue;
//             }
//             int check=(i==0)?pref[j]:pref[j]-pref[i-1];
//             // IO.println("Before"+check);
//             if(check%2!=0){
//                 cnt++;
//                 // IO.println(check);
//             }
//             j++;
//             // IO.println(j);
//         }
//         return (cnt%mod);
//     }
// }

class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=(int)1e9+7;

        long odd = 0, even = 1; // prefix sum 0 is even
        long ans = 0;
        int prefix = 0;

        for(int x : arr) {
            prefix += x;

            if(prefix % 2 == 0) {
                ans = (ans + odd) % mod;
                even++;
            } else {
                ans = (ans + even) % mod;
                odd++;
            }
        }

        return (int)ans;
    }
}