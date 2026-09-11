class Solution {
    public String simplifyPath(String path) {

        /*
        1 ---- > Ek Stack lele te hai directories ka Track rakhne ke liye 
        2  --- >  Split krdenge path ko slash se / 
        3  --- > for each loop se iterate karenge aur condition ke according stack mey push ya pop karenge
        4  ---- > Bakki bachi sab cheeze push krdenge stack mey
        5  --- > Bas last mey stack mey directories ko join krdenge
        */ 
        Stack<String> st=new Stack<>();
        String parts []= path.split("/");
       // IO.println(Arrays.toString(parts));
        for(String i:parts){
            if(i.equals(".")  || i.isEmpty()){
                continue;   // current directpry ya agar empty ho toh ignore 
            }
            else if(i.equals("..")){
                if(!st.isEmpty()){   // agar stack khali hua toh waise hi kam mhi ho payega  , ek type se safety check hai
                    st.pop();
                }
            }
            else{
                st.push(i);
            }
        }
        if (st.isEmpty()) {
            return "/";
        }

         
       StringBuilder sb = new StringBuilder();

        for (String it : st) {
            sb.append("/").append(it);
        }

        return sb.toString();
    }
}