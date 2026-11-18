// class Solution {
//     public int minChanges(String s) {
//         char current=s.charAt(0);
//         int cnt=0;
//         int minOps=0;
//         for(int i=0; i<s.length(); i++){
//             if(s.charAt(i)==current){
//                 cnt++;
//                 continue;
//             }
//             else if(cnt %2==0){
//                 cnt=1; // age wale ko calculate
//             }
//             else{
//                 cnt=0;
//                 minOps++;
//             }

//             current=s.charAt(i);
//         }
//         return minOps;
//     }
// }

// Another Approach
class Solution {
    public int minChanges(String s) {
        int n= s.length();
        int cnt= 0;
        for(int i=0; i< n; i+= 2){
            if(s.charAt(i)==s.charAt(i+1)){  // simple obervation 2-2 ke group check kre hai --> Consecutive follow krne ke liye
                continue;
            }
            else{
                cnt++;
            }
        }
        return cnt;
    }
}
