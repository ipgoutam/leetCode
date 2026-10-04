class Solution {
    public void backtrack(String digit, int digitIdx, HashMap<Character, String> hm, StringBuilder sb, List<String> ans){
        if(digitIdx == digit.length()){
            ans.add(sb.toString());
            return;
        }
        String curr = hm.get(digit.charAt(digitIdx));
        for(int k = 0; k< curr.length(); k++){
            sb.append(curr.charAt(k));
            backtrack(digit, digitIdx +1, hm, sb, ans);
            sb.deleteCharAt(sb.length() -1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        backtrack(digits, 0, hm, new StringBuilder(), ans);
        return ans;
    }
}