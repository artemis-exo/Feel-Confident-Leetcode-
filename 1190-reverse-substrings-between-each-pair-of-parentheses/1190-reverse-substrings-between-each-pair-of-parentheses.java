class Solution {
    /*
    ----- >> Phele Stack mey sare character push karenge only excluding ")" 
    -------- >> Jaise hi CLosing Bracket aya waise Pura stack Empty karenge Till Openning Bracket
    ------- >> And Store karenge in String Builder  Temporary mey (Khud hi reverse ho jayegea)
    ---- >> Agar sb ki Length!=0 hai toh phir ussi stack mey dal denge tkki age Koe aur closing bracket ho toh  Ops kar paye

    ---- >> At last res StringBuilder mey pure stack ko Empty kar denge

    */
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