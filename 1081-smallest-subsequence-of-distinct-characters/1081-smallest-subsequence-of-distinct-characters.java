class Solution {
    public String smallestSubsequence(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        boolean [] visit=new boolean[26];
        int lastSeen []=new int[26];
        Arrays.fill(lastSeen,-1);
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            lastSeen[ch-'a']=i;
        }
        for(int i=0; i<n;i++){
            char ch=s.charAt(i);
            if(visit[ch-'a'])
            continue;
            while(!sb.isEmpty() && ch<sb.charAt(sb.length()-1) && lastSeen[sb.charAt(sb.length()-1)-'a']>i){
                visit[sb.charAt(sb.length()-1)-'a']=false;
                sb.deleteCharAt(sb.length()-1);
            }
            visit[ch-'a']=true;
            sb.append(ch);
        }
        return sb.toString();
    }
}