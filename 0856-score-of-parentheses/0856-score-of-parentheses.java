class Solution {
    public int scoreOfParentheses(String s) {
        int depth=0;
        int cnt=0;
        for(int i=0; i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                depth++;
            }
            else{
                depth--;
                if(s.charAt(i-1)=='('){
                   cnt+=1<<depth;
                }
            }
        }
        return cnt;
    }
}