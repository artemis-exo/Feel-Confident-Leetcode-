class Solution {
    public int reverseDegree(String s) {
        int res=0,cnt=1;
       for(int i=0; i<s.length(); i++){
          int idx=(s.charAt(i)-'a')+1;
          int rev=27-idx;
            // IO.println(idx);
          res+= rev*cnt;
          cnt++;
       }
       return res;
    }
}