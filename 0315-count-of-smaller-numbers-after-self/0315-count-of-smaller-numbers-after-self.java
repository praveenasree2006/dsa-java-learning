import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int total = nums.length;
        int[] answer = new int[total];

        int lowest = nums[0];
        int highest = nums[0];
        for (int val : nums) {
            if (val < lowest) lowest = val;
            if (val > highest) highest = val;
        }
        int shift = 1 - lowest;
        int limit = highest - lowest + 2;
        int[] bit = new int[limit];

        for (int pos = total - 1; pos >= 0; pos--) {
            int key = nums[pos] + shift;
            int running = 0;
            for (int idx = key - 1; idx > 0; idx -= idx & -idx) {
                running += bit[idx];
            }
            answer[pos] = running;
            for (int idx = key; idx < limit; idx += idx & -idx) {
                bit[idx]++;
            }
        }

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int at) {
                return answer[at];
            }

            @Override
            public int size() {
                return total;
            }
        };
    }
}