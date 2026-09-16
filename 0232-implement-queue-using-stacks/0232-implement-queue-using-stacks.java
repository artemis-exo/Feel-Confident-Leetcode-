class MyQueue {
    Stack<Integer>mains;
    Stack<Integer>second;
    public MyQueue() {
        mains=new Stack<>();
        second=new Stack<>();
    }
    
    public void push(int x) {
        while(!mains.isEmpty()){
            second.push(mains.pop());
        }
        mains.push(x);
         while(!second.isEmpty()){
            mains.push(second.pop());
        }
    }
    
    public int pop() {
        return mains.pop();
    }
    
    public int peek() {
       return mains.peek();
    }
    
    public boolean empty() {
        return mains.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */