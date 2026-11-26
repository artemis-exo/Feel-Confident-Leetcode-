class Solution {
    public boolean canAliceWin(int n) {
    if(n<10){
    return false;
    }
        int flag=1;
        int cnt=10;
        while(n>=cnt){
           flag++;
           n=n-cnt;
            cnt--;
        }
        return flag%2==0?true:false;
    }
}