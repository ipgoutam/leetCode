class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        for(int i=1; i<=n; i++){
            ans[i]= getSetBit(i);
        }
        return ans;
    }
    public int getSetBit(int num){
        int count=0;
        while(num!=0){
            count++;
            num = num & (num-1);
        }
        return count;
    }
}