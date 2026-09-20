class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, matchCount = 0;
        for (char c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
                count++;
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (char c : t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    matchCount++;
                } else if (map.get(c) == -1) {
                    matchCount--;
                }
            } else {
                return false;
            }
        }

        return matchCount == count;
    }
}
