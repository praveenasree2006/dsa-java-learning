class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        Map<Integer, Integer> outgoingNum = new HashMap<>();
        PriorityQueue<Integer> smallList = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> largeList = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            smallList.offer(nums[i]);
        }

        for (int i = 0; i < k / 2; i++) {
            largeList.offer(smallList.poll());
        }

        int balance = 0;
        int index = 0;

        for (int i = k;; i++) {
            if (k % 2 == 1) {
                medians[index] = smallList.peek();
            } else {
                medians[index] = ((double) smallList.peek() + largeList.peek()) / 2.0;
            }

            if (i >= nums.length)
                break;

            int outNum = nums[i - k];
            int inNum = nums[i];
            index++;

            balance += (outNum <= smallList.peek()) ? -1 : 1;

            outgoingNum.put(outNum, outgoingNum.getOrDefault(outNum, 0) + 1);

            if (inNum <= smallList.peek()) {
                balance++;
                smallList.offer(inNum);
            } else {
                balance--;
                largeList.offer(inNum);
            }

            if (balance < 0) {
                smallList.offer(largeList.poll());
            } else if (balance > 0) {
                largeList.offer(smallList.poll());
            }

            balance = 0;

            while (outgoingNum.getOrDefault(smallList.peek(), 0) > 0) {
                outgoingNum.put(smallList.peek(), outgoingNum.get(smallList.peek()) - 1);
                smallList.poll();
            }

            while (!largeList.isEmpty() && outgoingNum.getOrDefault(largeList.peek(), 0) > 0) {
                outgoingNum.put(largeList.peek(), outgoingNum.get(largeList.peek()) - 1);
                largeList.poll();
            }
        }

        return medians;
    }
}