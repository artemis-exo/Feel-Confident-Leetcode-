class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        {
         return false;
        }
         int [] tempMap=new int[26];
        for(int i=0;i<s.length();i++){
            tempMap[s.charAt(i)-'a']++;
            tempMap[t.charAt(i)-'a']--;
        }
        for(int e:tempMap){
            if(e!=0){
                return false;
            }
        }
        return true;
        
        
    }
}