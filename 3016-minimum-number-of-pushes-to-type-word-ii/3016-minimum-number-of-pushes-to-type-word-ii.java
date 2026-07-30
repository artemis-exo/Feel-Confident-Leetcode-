class Solution {
    public int minimumPushes(String word) {
        int [] count=new int[26];
       for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            count[ch-'a']++;
        }
        int min =0;
        Arrays.sort(count);
        for(int i=0; i<26; i++){
            if(count[count.length-1-i]!=0){
                min+=(i/8+1)*count[count.length-1-i];
            }
        }
        return min;
    }
}