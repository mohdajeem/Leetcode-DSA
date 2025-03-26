class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length,m =grid[0].length;
        int[] ansArr = new int[n*m];
        int k =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                ansArr[k++] = grid[i][j];
            }
        }
        Arrays.sort(ansArr);
        int nm = ansArr.length;
        System.out.println(Arrays.toString(ansArr));
        // System.out.println(mid);
        // int tr = findLowerBound(ansArr, mid);
        // System.out.println(ansArr[tr]);
        int midInd = nm/2;
        int tr = ansArr[midInd];
        int ans = check(ansArr, x, tr);
        return ans;
    }
    public int check(int[] arr, int x, int tr){
        int ans = 0;
        for(int i =0;i<arr.length;i++){
            int val = Math.abs(tr-arr[i]);
            if(val%x!=0) return -1;
            else{
                ans+=(val/x);
            }
        }
        return ans;
    }
    public int findLowerBound(int[] arr, int target){
        int n = arr.length;
        int s = 0, e = n-1;
        int ans =0;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid] <= target){
                ans = mid;
                s=mid+1;
            }else{
                e = mid-1;
            }
        }
        return ans;
    }
}