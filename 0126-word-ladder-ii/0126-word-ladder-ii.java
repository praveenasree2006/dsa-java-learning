import java.util.*;

class Solution {
    String b;
    Map<String,Integer> mpp = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();

    private void dfs(String word, List<String> seq) {
        if (word.equals(b)) {
            List<String> temp = new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        int steps = mpp.get(word);
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char org = arr[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                arr[i] = ch;
                String nxt = new String(arr);
                if (mpp.containsKey(nxt) && mpp.get(nxt) + 1 == steps) {
                    seq.add(nxt);
                    dfs(nxt, seq);
                    seq.remove(seq.size() - 1);
                }
            }
            arr[i] = org;
        }
    }

    public List<List<String>> findLadders(String st, String tar, List<String> wordList) {
        Set<String> s = new HashSet<>(wordList);
        if (st.equals(tar)) {
            List<List<String>> res = new ArrayList<>();
            res.add(Arrays.asList(st));
            return res;
        }
        if (!s.contains(tar)) return new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add(st);
        mpp.put(st, 1);
        b = st;
        boolean found = false;

        while (!q.isEmpty() && !found) {
            int sz = q.size();
            for (int k = 0; k < sz; k++) {
                String cur = q.poll();
                int steps = mpp.get(cur);
                char[] arr = cur.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char org = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String nxt = new String(arr);
                        if (s.contains(nxt) && !mpp.containsKey(nxt)) {
                            mpp.put(nxt, steps + 1);
                            if (nxt.equals(tar)) found = true;
                            q.add(nxt);
                        }
                    }
                    arr[i] = org;
                }
            }
        }

        if (mpp.containsKey(tar)) {
            List<String> seq = new ArrayList<>();
            seq.add(tar);
            dfs(tar, seq);
        }
        return ans;
    }
}