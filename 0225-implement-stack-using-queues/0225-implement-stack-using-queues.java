class MyStack {
    Queue<Integer>mains;
    Queue<Integer>second;
    public MyStack() {
        mains=new LinkedList<>();
        second=new LinkedList<>();
    }
    
    public void push(int x) {
        while(mains.size()>0){
            second.add(mains.poll());
        }
        mains.add(x);
        while(second.size()>0){
            mains.add(second.poll());
        }
    }
    
    public int pop() {
      int x=mains.poll();  
      return x;
    }
    
    public int top() {
        int y=mains.peek();
        return y;
    }
    
    public boolean empty() {
        return mains.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */