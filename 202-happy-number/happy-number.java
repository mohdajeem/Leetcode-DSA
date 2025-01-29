class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        HashSet<Integer> hs = new HashSet<>();
        int temp = n;
        while(temp!=1){
            if(hs.contains(temp)) return false;
            hs.add(temp);
            int sumOfSquare = 0;
            while(temp > 0){
                int val = temp%10;
                sumOfSquare += val*val;
                temp /= 10;
            }
            temp = sumOfSquare;
        }
        return true;
        
    }
}