class RLEIterator {
    int[] encoding;
    int i, pointer;

    public RLEIterator(int[] encoding) {
       this.encoding = encoding;
        i=pointer = 0;
    }
    
    public long next(int n) {
       while(i < encoding.length){
        if(pointer + n > encoding[i]){
            n -= encoding[i] - pointer;
            pointer = 0;
            i+=2;
        } else{
            pointer += n;
            return encoding[i+1];
        }
       }
       return -1;

    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */