class Solution {
    public boolean checkString(String s) {
        if(s.length()==1){
            if(s.charAt(0)=='a'){
                return true;
            }
        }
       int a =s.lastIndexOf("a");
       int b=s.indexOf("b");
        return b!=-1?a<b:true;
    }
}