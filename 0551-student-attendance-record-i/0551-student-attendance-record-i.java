class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int lateCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'A') {
                absentCount++;
                if (absentCount >= 2) {
                    return false;
                }
            }

            if (ch == 'L') {
                lateCount++;
                if (lateCount >= 3) {
                    return false;
                }
            } else {
                lateCount = 0;
            }
        }

        return true;
    }
}