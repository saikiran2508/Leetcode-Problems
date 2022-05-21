class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){ 
            if(map.containsKey(nums[i])){
                //map.put(ele,map.get(ele)+1);
                continue;
            }
            map.put(nums[i],i);
        }
        int x[]=new int[2];
        for(int i=0;i<n;i++){
            int comp=target-nums[i];
            if(map.containsKey(comp) && map.get(comp)!=i){
                x[0]=i;
                x[1]=map.get(comp);
                break;
            }
        }
        return x;
    }
}