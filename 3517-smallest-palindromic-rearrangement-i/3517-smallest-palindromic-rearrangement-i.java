class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1)return s;
        int count[]=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        int odd=0;
         char oddChar=' ';
        for(int i=0;i<26;i++){
            if(count[i]%2!=0){
                odd++;
                oddChar=(char)(i+'a');
            }
        }
        StringBuilder sb1=new StringBuilder();
        for(int i=0; i<26;i++){
            int half=count[i]/2;
            char c=(char)(i+'a');
            for(int j=0;j<half;j++){
                sb1.append(c);
            }
        }
        StringBuilder sb2=new StringBuilder();
        sb2.append(sb1);
        if(odd==0){
            sb2.append(sb1.reverse());
        }
        else{
            sb2.append(oddChar);
            sb2.append(sb1.reverse());
        }
        return sb2.toString();
    }
}

// Another approach
class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1)return s;
        int n=s.length();
        int mid=s.length()/2;
        char ch[]=s.toCharArray();
        Arrays.sort(ch,0,mid);
        for(int i=0;i<mid;i++){
            ch[n-1-i]=ch[i];
        }
        return new String(ch);
    }
}
