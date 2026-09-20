class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!idxMap.containsKey(nums[i])) {
                idxMap.put(nums[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (idxMap.containsKey(target - nums[i])) {
                int j = idxMap.get(target - nums[i]);
                if (i == j) {
                    continue;
                } else if (i < j){
                    return new int[]{i, j};
                } else {
                    return new int[]{j, i};
                }
            }
        }

        return null;
    }
}
