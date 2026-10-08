 /// ----- >>> With Stack int O(N) Space

// class Solution {
//     public String removeOuterParentheses(String s) {
//         Stack<Character>st=new Stack<>();
//         StringBuilder sb=new StringBuilder();
//         for(char ch: s.toCharArray()){
//             if(ch=='('){
//             if(!st.isEmpty()){
//                 sb.append(ch);
//             }
//             st.push(ch);
//             }
//             else{
//                  st.pop();
//                if(!st.isEmpty()){
//                 sb.append(ch);
//             } 
           
//             }
//         }
//         return sb.toString();

//     }
// }

// Without Stack Uisng Pointers in O(1) Space

class Solution {
    public String removeOuterParentheses(String s) {
        int cnt=0;
        // Jab bhi cnt==0 hua mtlb outer hi hoga pkkka 
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(cnt!=0){ // Bhar wale opening ko avoid krne ke liye
                    sb.append(ch);
                }
                cnt++;
            }
            else{
                cnt--;
                if(cnt!=0){ // last outer ko avoid krne ke liye 
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}