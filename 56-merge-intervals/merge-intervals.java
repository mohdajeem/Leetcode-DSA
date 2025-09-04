class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0]-b[0];
        });
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i =0;
        while(i<n){
            int[] list = intervals[i];
            while(i+1<n && list[1] >= intervals[i+1][0]){
                list[1] = Math.max(list[1], intervals[i+1][1]);
                i++;
            }
            res.add(list);
            i++;
        }
        int[][] ans = new int[res.size()][2];
        int j =0;
        for(int[] it : res){
            ans[j++] = it;
        }
        return ans;

    }
}