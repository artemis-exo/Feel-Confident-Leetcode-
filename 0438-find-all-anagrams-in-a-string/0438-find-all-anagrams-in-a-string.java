class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       if(p.length()>s.length()){
        return  new ArrayList<>();
       }
       int [] cnt=new int[26];
       for(int i=0; i<p.length(); i++){
          cnt[p.charAt(i)-'a']++;
       }
       int j=0,i=0;
       List<Integer>li=new ArrayList<>();
       while(j<s.length()){
        cnt[s.charAt(j)-'a']--;
        if(j-i+1==p.length()){
            if(Anagram(cnt)){
                li.add(i);
            }
            cnt[s.charAt(i)-'a']++;
            i++;
        }
        j++;
         
       }
       return li;
    }
    public boolean Anagram(int [] cnt){
        for(int i:cnt){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}