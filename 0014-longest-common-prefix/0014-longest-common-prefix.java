class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
        return "";
        String first=strs[0];
        for(String s:strs){
            while(!s.startsWith(first)){
            first=first.substring(0,first.length()-1);

            if(first.isEmpty()){
               return  "";
            }
        }
        }
        
        return first;
    }
}