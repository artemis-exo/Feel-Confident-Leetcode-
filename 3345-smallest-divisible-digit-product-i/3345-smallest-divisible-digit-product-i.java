class Solution {
    public int smallestNumber(int n, int t) {
        int m=n+10;
        int prod=1;
        for(int i=n;i<m;i++){
            prod=1;
            int temp=i;
            while(temp>0){
            int digit=temp%10;
            prod=prod*digit;
            temp=temp/10;
            
            }
            //System.out.println(prod);
            if(prod%t==0){
            return i;
            }
        }
        return -1;
    }
}