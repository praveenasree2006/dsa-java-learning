class Fenvick{
    int n;
    int bit[];
    public Fenvick(int n){
        this.n=n;
        bit=new int[n+1];
    }
    public void update(int i,int val){
        while(i<=n){
            bit[i]+=val;
            i+=(i&(-i));
        }
    }
    public int sum(int i){
        int s=0;
        while(i>0){
            s+=bit[i];
            i-=(i&(-i));
        }
        return s;
    }
}
class NumArray {
    Fenvick ft;
    int nums[];
    public NumArray(int[] nums) {
        ft=new Fenvick(nums.length);  
        this.nums=nums;  
        for(int i=0;i<nums.length;i++){
            ft.update(i+1,nums[i]);
        }   
    }
    public void update(int index, int val) { 
        int diff=val-nums[index];
        nums[index]=val; 
        ft.update(index+1,diff);
    }
    public int sumRange(int left, int right) {
        return ft.sum(right+1)-ft.sum(left);  
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */