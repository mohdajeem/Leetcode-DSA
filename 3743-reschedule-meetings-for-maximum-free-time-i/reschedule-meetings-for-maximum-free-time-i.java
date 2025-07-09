class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> freeTime = new ArrayList<>();
        int n = startTime.length;
        int freeTm = startTime[0]-0;
        freeTime.add(freeTm);
        for(int i =1;i<n;i++){
            freeTm = startTime[i]-endTime[i-1];
            freeTime.add(freeTm);
        }
        freeTm = eventTime - endTime[n-1];
        freeTime.add(freeTm);
        int winSize = k+1;
        int l = 0, r=0;
        int max = 0, sum = 0;
        while(r<winSize-1){
            sum+=freeTime.get(r);
            r++;
        }
        while(r < freeTime.size()){
            sum+=freeTime.get(r);
            max = Math.max(sum, max);
            sum-=freeTime.get(l);
            r++;
            l++;
        }
        return max;

    }
}