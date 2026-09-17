class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {

        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        int overlap_width =
            Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));

        int overlap_height =
            Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        int overlap_area = overlap_width * overlap_height;

        int total_area = area1 + area2 - overlap_area;

        return total_area;
    }
}