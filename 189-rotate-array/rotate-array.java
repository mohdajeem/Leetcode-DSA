class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(0,n-k,nums);
        reverse(n-k,n,nums);
        reverse(0,n,nums);
    }
    public void reverse(int s, int e, int[] arr){
        e--;
        while(s<e){
            arr[s]=arr[s]^arr[e];
            arr[e]=arr[s]^arr[e];
            arr[s]=arr[s]^arr[e];
            s++;
            e--;
        }
    }
}