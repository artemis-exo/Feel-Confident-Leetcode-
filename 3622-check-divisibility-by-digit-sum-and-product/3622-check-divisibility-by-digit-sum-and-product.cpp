class Solution {
public:
    bool checkDivisibility(int n) {
        int prod=1, sum=0;
        int x=n;
        while(n>0){
            int digit=n%10;
            prod=prod*digit;
            sum=sum+digit;
            n=n/10;
        }
        return x%(sum+prod)==0;
    }
};