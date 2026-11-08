// class Solution {
//     public long countValidSubstrings(String s) {
//         int invalidIdx=-1;
//         long cnt=0;
//         for(int i=0; i<s.length(); i++){
//             if(i>=2 && s.charAt(i)=='c' && s.charAt(i-1)=='b' && s.charAt(i-2)=='a'){
//                 invalidIdx=i-2;
//             }
//             cnt+=(i-invalidIdx);
//         }
//         return cnt;
//     }
// }

// Doing same above approach in  rerverse Fashion
class Solution {
    public long countValidSubstrings(String s) {
        long n=s.length();
        long total=n*(n+1)/2;
        int lastIdx=-1;
        for(int i=0; i<n;  i++){
            if(i>=2 && s.charAt(i-2)=='a'&& s.charAt(i-1)=='b' && s.charAt(i)=='c'){
                lastIdx=i-1;
            }
            if(lastIdx>=0){
                total=total-(lastIdx);
            }
        }
        return total;
    }
}