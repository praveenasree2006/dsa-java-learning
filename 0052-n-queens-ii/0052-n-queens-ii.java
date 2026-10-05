class Solution {
    public int help(int i,int n,int[] col,int[] topLeft,int[] topRight){
        if(i==n) return 1;
        int count=0;
        for(int j=0;j<n;j++){
            if((col[j]==0) && (topLeft[i-j+n-1] ==0) && (topRight[i+j]==0)){
                col[j]=1;
                topLeft[i-j+n-1]=1;
                topRight[i+j]=1;

                count += help(i+1,n,col,topLeft,topRight);

                col[j]=0;
                topLeft[i-j+n-1]=0;
                topRight[i+j]=0;
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        int ans = 0;

        int[] col = new int[n];
        Arrays.fill(col,0);
        int[] topLeft = new int[2*n];
        Arrays.fill(topLeft,0);
        int[] topRight = new int[2*n];
        Arrays.fill(topRight,0);
        
        return help(0,n,col,topLeft,topRight);
    }
}