class Solution {
    public int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                ans = Math.min(ans, arr[left]);
                left++;
                right--;
                continue;
            }
            if (arr[left] <= arr[mid]) {
                ans = Math.min(ans, arr[left]);
                left = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                right = mid - 1;
            }
        }
        return ans;
    }
}