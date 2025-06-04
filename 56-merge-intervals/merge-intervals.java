class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        for(int i =0;i<intervals.length;i++){
            int[] list = new int[2];
            list[0] = intervals[i][0];
            list[1] = intervals[i][1];
            while(i<n-1 && list[1] >= intervals[i+1][0]){
                list[0] = Math.min(list[0],intervals[i+1][0]);
                list[1] = Math.max(list[1],intervals[i+1][1]);
                i++;
            }
            ans.add(list);
        }
        int[][] res = new int[ans.size()][2];
        int i =0;
        for(int[] li : ans){
            res[i++]=li;
        }
        return res;
    }
}