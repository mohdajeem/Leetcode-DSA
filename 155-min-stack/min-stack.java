class MinStack {
    Stack<Integer> st;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        setMin();
    }
    
    public void pop() {
        st.pop();
        min = Integer.MAX_VALUE;
        setMin();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
    public void setMin(){
        if(st.isEmpty()) return;
        int v = st.pop();
        min = Math.min(min, v);
        setMin();
        st.push(v);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */