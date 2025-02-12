class Solution {
    public boolean check(int[] arr) {
        int n = arr.length;
        int[] A = new int[n];
        for(int i = 0;i<n;i++){
            A[i] = arr[i];
        }
        Arrays.sort(A);
        int k = 0;
        int j = 0;
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i] > arr[i+1]){
                j = i+1;
                break;
            }
        }
        for(int i = j;j<n;j++){
            if(A[k] != arr[(k+i)%n]){
                return false;
            }
            k++;
        }
        return true;
    }
}