// class Solution {
//     public boolean checkValidString(String s) {
//         int open=0,close=0;
//         int star=0;
//         for(char ch :s.toCharArray()){
//             if(ch=='('){
//                 open++;
//             }
//             else if(ch==')'){
//                 close++;
//             }
//             else{
//                 star++;
//             }
//         }
//         IO.println("Open"+open);
//         IO.println("Close"+close);
//         IO.println("Star"+star);
//         if(Math.abs(open-close)==0){
//             return true;
//         }
//         int diff=Math.abs(open-close);
//          IO.println("Diff " +diff);
//         return star>=diff;
//     }
// }


class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int dp[][]=new int[n][n+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return ValidCheck(0,0,s,dp);
    }
    public boolean ValidCheck(int i, int opencnt, String s, int [][] dp){
        if(i==s.length()){
            return opencnt==0;
        }
        if(dp[i][opencnt]!=-1){
           return  dp[i][opencnt]==1;
        }
        boolean Valid=false;
        if(s.charAt(i)=='('){
          Valid= ValidCheck(i+1,opencnt+1,s,dp);
        }
        else if(s.charAt(i)=='*'){
            Valid|=ValidCheck(i+1,opencnt+1,s,dp);
            Valid|=ValidCheck(i+1,opencnt,s,dp);
            if(opencnt>0){
                Valid|=ValidCheck(i+1,opencnt-1,s,dp);
            }
        }
         else if(opencnt>0){
                Valid=ValidCheck(i+1,opencnt-1,s,dp);
            }

            dp[i][opencnt]=Valid?1:0;
            return Valid;
    }

}