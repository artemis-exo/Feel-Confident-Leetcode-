class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st=new Stack<>();
        for(int i:asteroids){
            if(i>0){
                st.push(i);
            }
            else{ // -tive num aya aur age usse phele wle abs() krke chote huye toh sare bhar 
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(i)){
                st.pop();
            }
            if(!st.isEmpty() && st.peek()==Math.abs(i)){ // agar dono same hue toh pop 
                st.pop();
            }
            else if(st.isEmpty() ||st.peek()<0){ // agar stack mey - tive element hai phele se toh same parity ka negative dal skte hai usse koe collision condition disturb nhi hori hai
                st.push(i);
            }
            }
            
        }
        int [] ans=new int[st.size()];
        for(int i=0;i<st.size(); i++){
            ans[i]=st.get(i);
        }
        return ans;
    }
}