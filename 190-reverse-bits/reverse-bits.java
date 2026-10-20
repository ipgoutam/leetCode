class Solution {
    public int reverseBits(int n) {
        int ans=0;
        int marks=1;
        for(int i=0; i<32; i++){
            if((marks&n) !=0){
                ans+=1<<31-i;
            }
            marks<<=1;
        }
        return ans;
    }
}