class Solution {
    public int differenceOfSums(int n, int m) {
        // sum(1-n)/2 -> gives sum upto n -> n*(n+1)/2 gives sum
        // now there are those values those are div by m
        // now to reduce them i will use 
        // see -> total no. till n that are div. by m => k = (n/m) call it k
        // 1*m + 2*m + 3*m +...k*m -> m(1+2+3+...k) => n2 = m*(k*(k+1)/2)
        // now i want to remove n2 from the value that aleady contain 1-n sum exclude n2
        // sum(1-n)-n2 -n2;
        // sum(1-n) - 2*n2;
        // return sum(1-n) - m*k*(k+1);
        int k = n/m;
        return (n*(n+1))/2 - m*k*(k+1);

    }
}