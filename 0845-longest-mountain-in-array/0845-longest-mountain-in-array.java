class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];   // increasing run ending at i
        int[] right = new int[n];  // decreasing run starting at i

        for (int i = 0; i < n; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        // climb from the left: extend the run if we're still going up
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) left[i] += left[i - 1];
        }

        // climb from the right: extend the run if we're still going down
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) right[i] += right[i + 1];
        }

        int maxi = 0;

        // a peak needs BOTH sides (> 1 each); peak counted once, hence -1
        for (int i = 0; i < n; i++) {
            if (left[i] > 1 && right[i] > 1)
                maxi = Math.max(maxi, left[i] + right[i] - 1);
        }

        return maxi;
    }
}