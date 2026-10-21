class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int top = 0;
        int side = 0;
        int front = 0;
        for(int i=0;i<n;i++)
            {
                int maxi = 0;
                for(int j=0;j<n;j++)
                    {
                        maxi = Math.max(maxi,grid[i][j]);
                        if(grid[i][j]!=0)top++;
                    }
                side += maxi;
            }
        for(int j=0;j<n;j++)
            {
                int maxi = 0;
                for(int i=0;i<n;i++)
                    {
                        maxi = Math.max(maxi,grid[i][j]);
                    }
                front += maxi;
            }
        return top+front+side;
    }
}