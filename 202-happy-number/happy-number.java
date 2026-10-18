class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenNumber = new HashSet<>();

        while( n!=1 && !seenNumber.contains(n)){
            seenNumber.add(n);
            n = getSumOfSquares(n);
        }

        return n==1 ;
    }
    public int getSumOfSquares(int n){
        int sum=0;
        while(n>0){
            int digit = n % 10;
            sum += digit*digit;
            n/=10;
        }
        return sum;
    }
}