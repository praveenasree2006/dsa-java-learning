class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }
        List<String> res = new ArrayList<>();
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i == first[s.charAt(i) - 'a']) {
                int newRight = checkValidRightBoundary(s, i, first, last);
                
                if (newRight != -1) {
                   
                    if (i > right) {
                        res.add("");
                    }
                    
                    right = newRight;
                    res.set(res.size() - 1, s.substring(i, right + 1));
                }
            }
        }
        
        return res;
    }
    
    public int checkValidRightBoundary(String s, int i, int[] first, int[] last) {
        int right = last[s.charAt(i) - 'a'];
        for (int j = i; j <= right; j++) {
            int c = s.charAt(j) - 'a';
            if (first[c] < i) {
                return -1;
            }
            
           right = Math.max(right, last[c]);
        }
        
        return right;
    }
}