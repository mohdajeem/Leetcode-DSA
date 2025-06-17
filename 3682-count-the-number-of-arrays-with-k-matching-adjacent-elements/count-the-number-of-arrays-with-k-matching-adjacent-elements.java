import java.util.*;

class Solution {
    int M = (int)1e9 + 7;

    public int countGoodArrays(int n, int m, int k) {
        long res = 1L * m * pow(m - 1, n - k - 1) % M;
        res = res * ncr(n - 1, k) % M;
        return (int) res;
    }

    public int ncr(int n, int r) {
        if (r > n) return 0;

        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1L);
        
        long a = fact(n, dp);
        long b = (fact(r, dp) * fact(n - r, dp)) % M;

        return (int) ((a * pow(b, M - 2)) % M);
    }

    public long fact(int n, long[] dp) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] != -1L) return dp[n];
        return dp[n] = (n * fact(n - 1, dp)) % M;
    }

    public int pow(long a, int b) {
        long res = 1;
        a %= M;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % M;
            }
            a = (a * a) % M;
            b >>= 1;
        }
        return (int) res;
    }
}
