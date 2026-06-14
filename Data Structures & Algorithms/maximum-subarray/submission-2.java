class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            max = Math.max(max, curSum);
        }
        return max;
    }
}
