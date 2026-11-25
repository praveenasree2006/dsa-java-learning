class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        
        
        if (x == y)
            return count;
        
        
        while (x > 0 || y > 0) {
            int xBit = 0;
            int yBit = 0;
            
            
            if (x > 0) {
                xBit = x % 2;
                x = Math.floorDiv(x, 2);
            }
            
            
            if (y > 0) {
                yBit = y % 2;
                y = Math.floorDiv(y, 2);
            }
            
            
            if (xBit != yBit)
                count++;
        }
        
        
        return count;
    }
}