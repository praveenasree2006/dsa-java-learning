class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> mp = new HashMap<>();
        for (String word : s1.split(" ")) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }
        for (String word : s2.split(" ")) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> it : mp.entrySet()) {
            if (it.getValue() == 1) {
                ans.add(it.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }
}