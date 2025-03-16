class Solution {
    public long repairCars(int[] ranks, int cars) {
        long max = Long.MIN_VALUE;
        for(int i : ranks){
            max = Math.max(max,i);
        }
        long s = 1, e = max*(long)cars*(long)cars;
        long minTime = 0;
        while(s<=e){
            long mid = s + (e-s)/2;
            if(timeTaken(ranks,cars,mid)){
                minTime=mid;
                e = mid-1;
            } else{
                s = mid+1;
            }
        }
        return minTime;
    }
    public boolean timeTaken(int[] ranks, int cars, long time){
        long sum = 0;
        for(int i =0;i<ranks.length;i++){
            long div = time/(long)ranks[i];
            sum += (long)Math.sqrt(div);
        }
        return cars <= sum;
    }
}