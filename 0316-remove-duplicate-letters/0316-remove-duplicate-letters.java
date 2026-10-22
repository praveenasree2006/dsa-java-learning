class Solution {
    public String removeDuplicateLetters(String s) {
        String res = "";
        Map<Character, Integer> M = new HashMap<>();
        Deque<Character> S = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            M.merge(c, 1, Integer::sum);
        }
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            M.merge(c, -1, Integer::sum);
            if (seen.contains(c)) continue;
            while (!S.isEmpty() && c < S.peek() && M.get(S.peek()) > 0) {
                seen.remove(S.peek());
                S.pop();
            }
            S.push(c);
            seen.add(c);
        }
        while (!S.isEmpty()) {
            res = S.peek() + res;
            S.pop();
        }
        return res;
    }
}
