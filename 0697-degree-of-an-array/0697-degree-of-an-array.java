class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            first.putIfAbsent(num, i);
            last.put(num, i);
        }

        int degree = 0;

        for (int count : freq.values()) {
            degree = Math.max(degree, count);
        }

        int minLength = nums.length;

        for (int num : freq.keySet()) {
            if (freq.get(num) == degree) {
                minLength = Math.min(
                    minLength,
                    last.get(num) - first.get(num) + 1
                );
            }
        }

        return minLength;
    }
}