class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i : piles){
            max = Math.max(max,i);
        }
        int s = 1, e = max;
        int ans = 0;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(canAssign(mid,piles,h)){
                ans = mid;
                e = mid-1;
            } else{
                s = mid+1;
            }
        }
        return ans;
    }
    public boolean canAssign(int mid, int[] piles, int h){
        int chk = 0;
        for(int i =0;i<piles.length;i++){
            chk += Math.ceil((double)((double)piles[i]/(double)mid));
        }
        // System.out.println("mid : "+mid+" "+"chk: "+chk+" true/false : "+(chk<=h));
        return chk <= h;
    }
}