class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            if(map.getOrDefault(num,0)>0){
                return num;
            }
            map.put(num,1);
        }
        return 0;
    }
}