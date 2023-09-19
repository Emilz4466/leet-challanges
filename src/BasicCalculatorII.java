import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    public List<Integer> basicCalc(String s) {
        List<String> operators = new LinkedList<String>(Arrays.asList("+", "-", "*", "/"));
        String currNum = "";
        List<Integer> nums = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));

            if(operators.contains(c)) {
                int x = Integer. valueOf(currNum);
                nums.add(x);
                currNum = "";
            } else {
                currNum += s.charAt(i);
            }
        }
        nums.add(Integer. valueOf(currNum));
        return nums;
    }

    public String print(List<Integer> nums) {
        String result = "";
        for(int num : nums) {
            result += "  " + num;
        }
        return result;
    }
}
