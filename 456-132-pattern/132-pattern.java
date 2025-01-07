class Solution {
    // ajeem
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack<Integer> st = new Stack<>();
        int sec_max = Integer.MIN_VALUE;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] < sec_max) {
                return true;
            }
            while (!st.isEmpty() && nums[j] > st.peek()) {
                sec_max = st.pop();
            }
            st.push(nums[j]);
        }
        return false;

    }
}