class Solution {
    Set<String> st=new HashSet<>();
    int maxlen;
    int n;
    public List<String> removeInvalidParentheses(String s) {
        maxlen=0;
        st.clear();
        n=s.length();
         dfs(s,0,new StringBuilder(),0);
         return new ArrayList<>(st);
    }
    public void dfs(String s,int i, StringBuilder curr, int count){
        if(count<0){
            return;
        }
        if(i==s.length()){
           if(count==0){
            if(curr.length()>maxlen){
                maxlen=curr.length();
                st.clear();
            }
            if(curr.length()==maxlen){
                st.add(curr.toString());
            }
           }
            return;
        }
       
        char ch=s.charAt(i);
        if(ch!='(' && ch!=')'){
            curr.append(ch);
            dfs(s,i+1,curr,count);
            curr.deleteCharAt(curr.length()-1);
            return;
        }
        curr.append(ch);
        dfs(s,i+1,curr,count+(ch=='(' ?1 :-1));
        curr.deleteCharAt(curr.length()-1);
        dfs(s,i+1,curr,count);
    }
}