class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(isOperator(token)){
                int a = stack.pop();
                int b = stack.pop();
                int result = applyOperator(token, a, b);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    private int applyOperator(String operator, int a, int b){
        switch(operator){
            case "+" : return b + a;
            case "-" : return b - a;
            case "*" : return b * a;
            case "/" : return b / a;
            default : throw new IllegalArgumentException("Invalid operator");
        }
    }
}