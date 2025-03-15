class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] arr : matrix){
            boolean flag = binarySearch(arr, target);
            if(flag) return true;
        }
        return false;
    }
    public boolean binarySearch(int[] arr, int target){
        int s = 0, e = arr.length-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr[mid] == target){
                return true;
            } else if(arr[mid] < target){
                s = mid+1;
            } else{
                e =mid-1;
            }
        }
        return false;
    }
}