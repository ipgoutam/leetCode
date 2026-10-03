class Solution {
    List<List<String>> res = new ArrayList<>();
    int n;
    public boolean isPalindrom(String s, int stIdx, int endIdx){
        while(stIdx < endIdx){
            if(s.charAt(stIdx) != s.charAt(endIdx)){
                return false;
            }
            stIdx++;
            endIdx--;
        }
        return true;
    }
    public void recurr(String s, int partIdx, List<String> subList){
        //base case
        if(partIdx == n){
            res.add(new ArrayList<>(subList));
            return;
        }
        // explore the possibility
        for(int end = partIdx; end < n; end++){
            if(isPalindrom(s, partIdx, end)){
                subList.add(s.substring(partIdx, end+1));
                //explore
                recurr(s, end+1, subList);
                //backtraking
                subList.remove(subList.size() -1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        n = s.length();
        recurr(s,0, new ArrayList<>());
        return res;
    }
}