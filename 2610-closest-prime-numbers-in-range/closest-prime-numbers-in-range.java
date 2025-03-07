class Solution {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = left; i<= right;i++){
            if(isPrime(i)){
                primes.add(i);
            }
        }
        int mini = Integer.MAX_VALUE;
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        for(int i = 0;i<primes.size()-1;i++){
            if((primes.get(i+1)-primes.get(i))<mini){
                mini = (primes.get(i+1)-primes.get(i));
                ans[0] = primes.get(i);
                ans[1] = primes.get(i+1);
            }
        }
        return ans;
    }
    public boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}