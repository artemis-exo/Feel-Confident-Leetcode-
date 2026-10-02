class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        Gen(ans,0,0,new StringBuilder(),n);
        return ans;
    }
    public void Gen(List<String> res, int open , int close, StringBuilder sb, int n){
        if(sb.length()==2*n){
            res.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append('(');
            Gen(res,open+1,close,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            Gen(res,open,close+1,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}