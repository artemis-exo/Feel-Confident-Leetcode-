class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int len=s.length();
        int active=0,max=0;
        List<Integer>inactive=new ArrayList<>();
        for(int i=0; i<len; i++){
            if(s.charAt(i)=='1')
            active++;
        }
        int i=0;
        while(i<len){
            if(s.charAt(i)=='0'){
                int counter=i;
                while(i<len && s.charAt(i)=='0')
                i++;
                inactive.add(i-counter);
            }
            else{
                i++;
            }
        }
        for(int j=1;j<inactive.size();j++){
            max=Math.max(max,inactive.get(j)+inactive.get(j-1));
        }
        return active+max;
    }
}