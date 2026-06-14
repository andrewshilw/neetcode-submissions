class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int lastEnd = merged.get(merged.size() - 1)[1];

            if (start <= lastEnd) {
                merged.get(merged.size() - 1)[1] = Math.max(end, lastEnd);
            } else {
                merged.add(interval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
