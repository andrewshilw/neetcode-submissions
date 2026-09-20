class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            new Comparator<Integer>(){
                @Override
                public int compare(Integer one, Integer two) {
                    return Integer.compare(map.getOrDefault(one, 0),
                                           map.getOrDefault(two, 0));
                }
            }
        );

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(n);
            } else if (map.getOrDefault(n, 0) > 
                       map.getOrDefault(minHeap.peek(), 0)) {
                minHeap.poll();
                minHeap.offer(n);       
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
