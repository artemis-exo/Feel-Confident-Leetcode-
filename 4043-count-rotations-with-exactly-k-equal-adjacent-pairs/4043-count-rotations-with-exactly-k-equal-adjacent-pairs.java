class Solution {
    public int countRotations(String s, int k) {
        int res=0, cnt =0;
        for(int i=0; i<s.length(); i++){
            cnt=0;
            for(int j=0; j<s.length()-1;j++){
                if(s.charAt(j)==s.charAt(j+1)){
                    cnt++;
                }
            }
            s=s.substring(1)+s.charAt(0);
            if(cnt==k)
            res++;
        }
        return res;
    }
}