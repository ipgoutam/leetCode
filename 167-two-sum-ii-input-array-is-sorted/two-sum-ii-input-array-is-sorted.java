class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int st = 0;
        int ed = numbers.length-1;
        while(st<ed){
            if(numbers[st] + numbers[ed] == target){
                return new int[]{st+1,ed+1}; 
            }else if(numbers[st] + numbers[ed] < target){
                st++;
            }else{
                ed--;
            }
        }
        return null;
    }
}