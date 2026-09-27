class Solution {
    public String reverseParentheses(String s) {
        Stack<Character>st=new Stack<>();
    
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=')'){
                st.push(s.charAt(i));
            }
            else{
                StringBuilder sb=new StringBuilder();
                while(st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();
                if(sb.length()!=0){
                    //sb.setLength(0); 
                    for (int j = 0; j < sb.length(); j++) {
                        st.push(sb.charAt(j));
                  }

                }
            }
           
        }
        StringBuilder res = new StringBuilder();
        for (char c : st) { 
            res.append(c);
        }
         return res.toString();
    }
}