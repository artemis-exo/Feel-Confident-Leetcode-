class Solution {
    public int maxDepth(String s) {
        int cnt=0;
        int max=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                cnt++;
                if(cnt>max){
                    max=cnt;
                }
            }
            else if(c==')'){
                cnt--;
            }
        }
        return max;
    }
}