class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }
        Map<Character, Integer> mapT = new HashMap<>();

        for(int i=0; i< t.length(); i++){
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i),0) +1);
        }
        int required = mapT.size();
        int l =0, r = 0;
        int create = 0;
        int []ans = {-1, 0, 0};
        Map<Character, Integer> subString = new HashMap<>();

        while(r<s.length()){
            char c = s.charAt(r);
            int count = subString.getOrDefault(c,0);
            subString.put(c, count +1);
            if(mapT.containsKey(c) && subString.get(c).intValue() == mapT.get(c).intValue()){
                create++;
            }

            while(l<=r && required == create){
                c = s.charAt(l);
                if(ans[0] == -1 || ans[0] >= r-l+1){
                    ans[0] = r - l +1;
                    ans[1] = l;
                    ans[2] = r;
                }
                subString.put(c, subString.get(c) - 1);
                if(mapT.containsKey(c) && subString.get(c).intValue() < mapT.get(c).intValue()){
                    create--;
                }
                l++;
            }
            r++;
        }
        if(ans[0] == -1) {
            return "";
        }

        return s.substring(ans[1], ans[2] + 1);
    }
}