class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
       findSubsets(nums, 0, new ArrayList<>());
       return res; 
    }
    public void findSubsets(int nums[], int idx, List<Integer> sublist){
        if(idx == nums.length){
            res.add(new ArrayList<>(sublist));
            return;
        }

        sublist.add(nums[idx]);
        findSubsets(nums, idx+1, sublist);

        sublist.remove(sublist.size()-1);

        findSubsets(nums, idx+1, sublist);
    }
}