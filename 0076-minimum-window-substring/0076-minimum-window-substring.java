class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return"";
        }
        // Phele Freq nikal lete hai
        Map<Character,Integer>map=new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
       // IO.println(map);
       int j=0, i=0, minWin=Integer.MAX_VALUE;
       int start=0;
       int sizeWin=t.length();
       // Now Sliding window starts
       while(j<s.length()){
        char ch=s.charAt(j);
        // Jo char Map mey hai aur jiksi freq count > 0 se toh count -- krdo
        if(map.containsKey(ch) && map.get(ch)>0){
             sizeWin--;
        }
        // aur freq bhi kam krdo us char ki
        map.put(ch,map.getOrDefault(ch,0)-1);
        // jaise hi ek window mile check krenge ki new window minWin se kam hai , hai toh assiign krdenge
        while(sizeWin==0){
            int currSize=j-i+1;
            if(currSize<minWin){
                minWin=currSize;
                start=i;
            }
            // Aur har step mey freq ko retore karenge i ki side se 
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
           // Aur count ++ ko bhi restore karenge
            if(map.containsKey(c) && map.get(c)>0){
                sizeWin++;
            }
            i++;
        }
        j++;
       }
        return minWin==Integer.MAX_VALUE ?"" :s.substring(start,start+minWin);
    }
}