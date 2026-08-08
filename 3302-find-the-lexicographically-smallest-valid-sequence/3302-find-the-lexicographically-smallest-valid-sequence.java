class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int suffix[]=new int[n+1];
        int i=n-1;
        int j=m-1;
        int match=0;
        while(i>=0){
            if(j>=0 && word1.charAt(i)==word2.charAt(j)){
                match++;
                j--;
            }
            suffix[i]=match; // fill suffix array with matched characters
            i--;
        }
        List<Integer> li=new ArrayList<>();
        i=0;j=0;
        boolean power=true;
        while(i<n && j<m){
          if(word1.charAt(i)==word2.charAt(j)){
            li.add(i);
            j++;
          }
          else if(power &&  suffix[i+1]>=m-j-1){
            li.add(i);
            j++;
            power=false;
          }
          i++;
        }
        if(j==m){
            int [] ans=new int[li.size()];
            for(int it=0; it<li.size(); it++){
               ans[it]=li.get(it);
            }
            return ans;
        }
        return new int[0];
    }
}