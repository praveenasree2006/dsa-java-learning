class MedianFinder {
    PriorityQueue<Integer> minpq = new PriorityQueue<>();
    PriorityQueue<Integer> maxpq =
        new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {

    }

    public void addNum(int num) {
        maxpq.add(num);

        if (!maxpq.isEmpty() && !minpq.isEmpty()
            && maxpq.peek() > minpq.peek()) {
            int val = maxpq.remove();
            minpq.add(val);
        }

        if (minpq.size() > maxpq.size() + 1) {
            int val = minpq.remove();
            maxpq.add(val);
        }

        if (minpq.size() + 1 < maxpq.size() + 1) {
            int val = maxpq.remove();
            minpq.add(val);
        }
    }

    public double findMedian() {
        if (maxpq.size() > minpq.size()) {
            return maxpq.peek();
        }

        if (maxpq.size() < minpq.size()) {
            return minpq.peek();
        }

        return (maxpq.peek() + minpq.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */