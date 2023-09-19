import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

/*
Given a string s which represents an expression, evaluate this expression and return its value.
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1


Example 3:
Input: s = " 3+5 / 2 "
Output: 5

Constraints:
1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/

public class BasicCalculatorII {

    public LinkedList<Arithemtic> basicCalc(String s) {
        List<String> operators = new LinkedList<String>(Arrays.asList("+", "-", "*", "/"));
        String currNum = "";
        LinkedList<Integer> nums = new LinkedList<>();
        String c;
        LinkedList<Arithemtic> artithemtics = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            c = String.valueOf(s.charAt(i));

            if (operators.contains(c)) {
                int x = Integer.parseInt(currNum);
                nums.add(x);
                currNum = "";
                artithemtics.add(new Arithemtic(c));

            } else if (!c.equals(" ")) {
                currNum += s.charAt(i);
                artithemtics.add(new Arithemtic(Integer.parseInt(currNum)));
            }
        }
        //TODO pomysł jest dobry ale nie mozna modyfikować listy jak jest w loopie
        LinkedList<Arithemtic> results = new LinkedList<>();
        for(Arithemtic arithemtic : artithemtics) {
            if(operators.contains(arithemtic.oper)) {
                switch(arithemtic.oper){
                    case "*":
                        results.add(new Arithemtic(artithemtics.get(artithemtics.indexOf(arithemtic) - 1).num * artithemtics.get(artithemtics.indexOf(arithemtic) + 1).num));
                        artithemtics.remove(artithemtics.indexOf(arithemtic) + 1);
                        break;
                    case "/":
                        results.add(new Arithemtic(artithemtics.get(artithemtics.indexOf(arithemtic) - 1).num / artithemtics.get(artithemtics.indexOf(arithemtic) + 1).num));
                        artithemtics.remove(artithemtics.indexOf(arithemtic) + 1);
                        break;
                }
            }
        }

        return results;
    }

    public static class Arithemtic {
        public int num = -1;
        public String oper = "";

        Arithemtic(int num, String oper) {
            this.num = num;
            this.oper = oper;
        }

        Arithemtic(int num) {
            this.num = num;
        }

        Arithemtic(String oper) {
            this.oper = oper;
        }
    }






    public String print(List<Integer> nums) {
        String result = "";
        for(int num : nums) {
            result += "  " + num;
        }
        return result;
    }

    public enum ArithmeticOperator implements BiFunction<Integer, Integer, Integer> {
        PLUS("+", (a, b) -> a + b),
        MINUS("-", (a, b) -> a - b),
        MULTIPLY("*", (a, b) -> a * b),
        DIVIDE("/", (a, b) -> a / b);

        private final String symbol;
        private final BiFunction<Integer, Integer, Integer> operation;

        ArithmeticOperator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
            this.symbol = symbol;
            this.operation = operation;
        }

        public Integer apply (Integer a, Integer b) {
            return operation.apply(a, b);
        }

        public String toString() {
            return symbol;
        }
    }
}
