class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        List<int[]> ans = new ArrayList<>();
        int[] curr = intervals[0];

        ans.add(curr);
        for(int[] interval : intervals){
            int currEnd = curr[1];
            int nextS = interval[0];
            int nextE = interval[1];
            if(nextS <= currEnd){
                curr[1] = Math.max(currEnd, nextE);
            } else{
                curr = interval;
                ans.add(curr);
            }
        }

        return ans.toArray(new int[ans.size()][]);

    }
}