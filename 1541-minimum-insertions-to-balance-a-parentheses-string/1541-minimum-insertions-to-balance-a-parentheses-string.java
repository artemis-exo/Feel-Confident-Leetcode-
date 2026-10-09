class Solution {
    public int minInsertions(String s) {
        int i=0,cnt=0,ans=0;
        /*
        cnt --- >> Yeh batata hai ki kitne opening bracket hai agr cnt mey last mey kuch openning reh jate hai toh iska mtlb ki 2*cnt chaihye honge balance krne ke liye
        res  ----->> res no of kitne req hai uska count hai
        */
        while(i<s.length()){
          if(s.charAt(i)=='('){
            i++;
            cnt++;
          }
          else{
            if(cnt>0){
                cnt--;
            }
            else{
                ans++;  // Insert karo "("
            }
            if(i<s.length()-1 && s.charAt(i+1)==')'){
                i=i+2;  // Yeh pair hai "))" Toh side dono se age jao age ke chekc karo
            }
            else{   //  insert ")"
                ans++; // Nhi hai agr upper wali condition toh phele ans++ karo phir next index pe 
                i++;
            }
          }
        }
        //IO.println(cnt);
        return ans+=cnt<<1;
    }
}