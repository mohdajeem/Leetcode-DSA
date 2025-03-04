class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n!=0){
            int i =0;
            while(Math.pow(3,i)<=n){
                i++;
            }
            n=n-(int) Math.pow(3,i-1);
            // System.out.println(n);
            if(Math.pow(3,i-1)<=n) return false;
            // System.out.println(i-1);
        }
        return true;
    }
    
}