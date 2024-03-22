class Solution {
    public int splitArray(int[] nums, int k) {
        //finding range what are the possible answers
        //first min-case:if m=length of array min=max element in array
        //second max-case:if m=1 then max=total sumof array
        //applying binary search in range
        //NOTE: if find ing potential answer in range apply binary search
        int start=nums[0];
        int end=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>start){
                start=nums[i];
            }
            end=end+nums[i];
        }
        while(start<end){
            int mid= start+(end-start)/2;
            int peices=1;
            int count=0;
            for(int i=0;i<nums.length;i++){
                if(count+nums[i]>mid){
                    count=0;
                    peices+=1;
                }
                count+=nums[i];
            }
            if(peices<=k){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}