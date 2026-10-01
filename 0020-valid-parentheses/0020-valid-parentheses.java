class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for( char ch: s.toCharArray()){
            if(ch=='('|| ch=='[' ||ch=='{'){
                stack.push(ch);
            }
            else{
             if(stack.isEmpty()){
                return false;
            }
            char del=stack.pop();
            if(ch==')'&& del!='('){
                return false;
            }
            if(ch==']' && del!='['){
                return false;
            }
            if(ch=='}'&& del!='{'){
                return false;
            }
            }

        }
        return stack.isEmpty();
    }
}