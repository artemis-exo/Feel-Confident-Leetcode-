class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>st=new Stack<>();
        int cnt=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(ch);
            }
            else {
                if(st.isEmpty()){
                    cnt++;
                }
                else{
                    st.pop();
                }
            }
        }
        return st.size()+cnt;
    }
}

// Appraoch -2 Without Stack
/*
Bina stack ke bhi kr skte hai kyuki ultimately stack ka size hi chahiye
--- > Like st.push == come++
---- >> Like st.pop() go++;
*/

class Solution {
    public int minAddToMakeValid(String s) {
        int come =0, go=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                come++;
            }
            else{
                if(come>0){
                    come--;
                }
                else{
                    go++;
                }
            }
        }
        return come +go;
    }
}
