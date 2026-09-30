class Solution {
    public static void backtrack(String num,int tar,int index,long value,long prev, String expression ,List<String>ans){
        if(index==num.length()){
            if(value==tar){
                ans.add(expression);
            }
            return;
        }

        for(int i=index;i<num.length();i++){
            if(i>index && num.charAt(index)=='0'){
                break;
            }

            long curr=Long.parseLong(num.substring(index,i+1));

        if(index==0){
            backtrack(num,tar,i+1,curr,curr,expression+curr,ans);
        }else{
            backtrack(num,tar,i+1,value+curr,curr,expression+"+"+curr,ans);
        backtrack(num,tar,i+1,value-curr,-curr,expression+"-"+curr,ans);
        backtrack(num,tar,i+1,value-prev+prev*curr,prev*curr,expression+"*"+curr,ans);
    }
        }

    }
    public List<String> addOperators(String num, int target) {
        List<String>ans=new ArrayList<>();
        backtrack(num,target,0,0,0,"",ans);
        return ans;
    }
}