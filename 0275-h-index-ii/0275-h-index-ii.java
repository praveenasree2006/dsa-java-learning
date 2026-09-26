class Solution {
    int n;
    public int hIndex(int[] arr) {
        n=arr.length;
        int low=0;
        int high=n;
        
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(arr,mid)){
                ans=mid;
                low=mid+1;
                 

            }
            else high=mid-1;
        }
        return ans;


    }
    public boolean helper(int arr[],int mid){
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=mid) count++;
          
        }
        return count>=mid;
    }
}