class Solution {
    public int maxProfit(int[] p) {
        int n = p.length;
        if (n < 2) return 0;
        int b = -p[0], s = 0, r = 0, pb, ps;
        for (int i = 1; i < n; i++) {
            pb = b;
            ps = s;
            b = Math.max(b, r - p[i]);
            s = Math.max(s, pb + p[i]);
            r = Math.max(r, ps);
        }
        return Math.max(r, s);
    }
}