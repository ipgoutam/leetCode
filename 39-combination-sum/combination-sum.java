class Solution {
    private void findCombination(int idx, int[]arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(idx == arr.length) return;

        if(arr[idx] <= target){
            ds.add(arr[idx]);
            findCombination(idx, arr, target - arr[idx], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombination(idx+1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0,candidates, target, ans , new ArrayList<>());
        return ans;
    }
}