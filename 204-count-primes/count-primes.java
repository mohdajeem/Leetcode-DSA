class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes,true);
        for(int i = 2;i*i<n;i++){
            if(primes[i]){
                for(int j = i*i;j<n;j+=i){
                    primes[j]=false;
                }
            }
        }
        int c =0;
        for(int i =2;i<n;i++){
            if(primes[i]) c++;
        }
        return c;
    }
}