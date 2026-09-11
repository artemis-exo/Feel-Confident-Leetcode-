class Solution {
    public int totalNumbers(int[] digits) {
      /*
      1 --- > My approach is simple brute force and trying all combinations as per question reqiuremnet
      2 -- > forming 3 digit even number using i==Hundredth Place , j==Tens Place , K=One's Place
      3 --- > Digit shuld be unique and even so i used a Set Data Structure for this ans stores in that
      4 ---- > After processing all the Combinations i just simple return the size of Set 

       --------------------- >>> My Thousght process for approaching this
      */
        Set<Integer>st=new HashSet<>();
        int n=digits.length;
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(k==j || i==j || i==k){
                        continue;
                    }
                    int digi=digits[i]*100 +digits[j]*10 +digits[k];
                    if(digi>=100 && digi%2==0){
                        st.add(digi);
                    }
                }
            }
        }
        return st.size();
    }
}