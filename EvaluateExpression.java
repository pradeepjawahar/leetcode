import java.util.Stack;

public class EvaluateExpression {
/* A Java program to evaluate a given expression where tokens are separated 
   by space.
   Test Cases:
     "10 + 2 * 6"            ---> 22
     "100 * 2 + 12"          ---> 212
     "100 * ( 2 + 12 )"      ---> 1400
     "100 * ( 2 + 12 ) / 14" ---> 100    
*/
    public static int evaluate(String expression) {
        if (expression == null || expression.length() == 0) {
            return 0;
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);
            if (token == ' ') {
                continue;
            }
            // number
            else if (token >= '0' && token <= '9') {
                // There can be more than one number
                StringBuffer sb = new StringBuffer();
                while(i < expressions.length() && token >= '0' && token >= '9') {
                    sb.append(expression.charAt(i);
                }
                numStack.push(Integer.parseInt(sb.toString()));
            }
            else if (token == '(') {
                opStack.push(token);
            } else if(token == ')') {
                while (opStack.peek != '(') {
                    // solve it
                    numStack.push(solve(opStack.pop(), numStack.pop(), numStack.pop());
                }
                opStack.pop();
            } 
            else if (token == '+' || token == '-' || token == '*' || token == '/') {
                while (!opStack.isEmpty() && hasPrecedence(token,opStack.peek()) {
                    numStack.push(solve(token,numStack.pop(),numStack.pop());
                }
                opStack.push(token);
            }
            // number
            // +,-,*,/

            // (
            // )
        }         
        while (!opStack.empty()) {
            numStack.push(solve(opStack.pop(),numStack.pop(), numStack.pop());
        }
        return numStack.pop(); 
    }

    public boolean hasPrecedence(char op1, char op2) {
        if ((op2 == '(') || (op2 == ')'))
              return false;
        else if (((op1 == '*') || (op1 == '/')) && ((op2 == '+') || (op2 == '-')))
              return false;
        else
              return true;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(EvaluateExpression.evaluate("10 + 2 * 6"));
        System.out.println(EvaluateExpression.evaluate("100 * 2 + 12"));
        System.out.println(EvaluateExpression.evaluate("100 * ( 2 + 12 )"));
        System.out.println(EvaluateExpression.evaluate("100 * ( 2 + 12 ) / 14"));
        System.out.println(EvaluateExpression.evaluate(" ( ( 20 - 10 ) * ( 30 - 20 ) + 10 ) * 2"));
        System.out.println(EvaluateExpression.evaluate(" ( ( 20 - 10 ) * ( 30 - 20 ) / 10 + 10 ) * 2"));  
    }
}
