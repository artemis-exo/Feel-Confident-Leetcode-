class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        if(n<=8)return n;
        int min=0;
        for(int i=0; i<n; i++){
             min+=(i/8)+1;
        }
        return min;
    }
}