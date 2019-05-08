/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problembase;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author kaoTuLocalAccount
 */
public class BalanceParentheses {

    /**
     * @param args the command line arguments
     */
//    จาก String ที่กำหนดวงเล็บรูปแบบต่าง ๆ “()[]{}” ให้ตรวจสอบว่ามีวงเล็บเปิดปิด จำนวนเท่ากันและอยู่ในลำดับการเปิดปิดที่สอดคล้องกันหรือไม่ ให้ส่งผลลัพธ์เป็นค่า boolean
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
            System.out.println("Input : " + input);
        if (isExpressionBalanced(input)) {
            System.out.println("Output : "+"true - เป็นวงเล็บที่มีความสมดุล");
        } else {
            System.out.println("Output : "+"false - เป็นวงเล็บที่ไม่มีความสมดุล");
        }
    }

    static boolean isExpressionBalanced(String input) {
        Stack stack = new Stack();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                System.out.println(input.charAt(i));
                stack.push(input.charAt(i));
            }
            if (input.charAt(i) == ')' || input.charAt(i) == '}' || input.charAt(i) == ']') {
                if (stack.empty()) {
                    return false;
                }
                char top_char = (char) stack.pop();
                if ((top_char == '(' && input.charAt(i) != ')') || (top_char == '{' && input.charAt(i) != '}') || (top_char == '[' && input.charAt(i) != ']')) {
                    return false;
                }
            }
        }
        System.out.println(stack.empty());
        return stack.empty();
    }
//    static boolean isExpressionBalanced(String input) {
//        Stack stack = new Stack();
//        for (int i = 0; i < input.length(); i++) {
//            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
//                System.out.println(input.charAt(i));
//                stack.push(input.charAt(i));
//            }
//            if (input.charAt(i) == ')' || input.charAt(i) == '}' || input.charAt(i) == ']') {
//                if (stack.empty()) {
//                    return false;
//                }
//                char top_char = (char) stack.pop();
//
//                if ((top_char == '(' && input.charAt(i) != ')') || (top_char == '{' && input.charAt(i) != '}') || (top_char == '[' && input.charAt(i) != ']')) {
//                    return false;
//                }
//            }
//        }
//        return stack.empty();
//    }
}


//แยก method 
