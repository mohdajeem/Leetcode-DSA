class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;
        int e = Integer.MIN_VALUE, s = 0;
        for(int i : bloomDay){
            e = Math.max(i,e);
        }
        int ans = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(canMake(mid, bloomDay, m, k)){
                System.out.println("True");
                ans = mid;
                e=mid-1;
            } else{
                s = mid+1;
            }
        }
        return ans;
    }
    public boolean canMake(int mid, int[] bloomDay, int m, int k){
        int minBoquet = 0;
        for(int i =0;i<bloomDay.length;i++){
            int count = 0;
            while(i<bloomDay.length && bloomDay[i] <= mid){
                count++;
                i++;
            }
            minBoquet += (count/k);
        }
        return minBoquet >= m;
    }
}