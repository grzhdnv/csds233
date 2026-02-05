package week4;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.exit;

public class CodeReading2 {
    public static void main(String[] args) {

        Stack<Character> myStack = new Stack<>();

        Scanner kb = new Scanner(System.in);
        System.out.print("Enter a statement to evaluate (ending with a #)");
        String s = kb.nextLine();

        if (s.charAt(s.length() - 1) != '#') {
            System.out.println("Invalid input: you must end with '#");
            exit(-1);
        }

        int i = 0;
        while(i<s.length()){
            Character token = s.charAt(i);
            System.out.print("Token = "+token+" ");
            switch (token) {
                case '{':
                case '(':
                case '[': {
                    myStack.push(token);
                    System.out.println("Push " + token);
                    break;
                }
                case '}': {
                    if (myStack.empty()) {
                        System.out.println("Stack is empty");
                        System.out.println();
                        System.out.println("Evaluation: Encountered an unmatched " + token);
                        exit(-1);
                    }
                    Character t = myStack.pop();
                    System.out.println("Pop " + t);
                    if (t != '{')  {
                        System.out.println();
                        System.out.println("Evaluation: Encountered an unmatched " + token);
                        exit(-1);
                    }
                    break;
                }
                case ')': {
                    if (myStack.empty()) {
                        System.out.println("Stack is empty");
                        System.out.println();
                        System.out.println("Evaluation: Encountered an unmatched " + token);
                        exit(-1);
                    }
                    Character t = myStack.pop();
                    System.out.println("Pop " + t);
                    if (t != '(') {
                        System.out.println();
                        System.out.print("Evaluation: Encountered an unmatched " + token);
                        exit(-1);
                    }
                    break;
                }

                case ']': {
                    if (myStack.empty()) {
                        System.out.println("Stack is empty");
                        System.out.println();
                        System.out.println("Evaluation: Encountered an unmatched " + token);
                        exit(-1);
                    }
                    Character t = myStack.pop();
                    System.out.println("Pop " + t);
                    if (t != '[')  {
                        System.out.println();
                        System.out.println("Evaluation: Encountered an unmatched " + token);
                        exit(-1);
                    }
                    break;
                }

                case '#':{
                    if (myStack.empty()){
                        System.out.println();
                        System.out.println("Evaluation: Balanced Expression");
                        exit(0);
                    }
                    else{
                        System.out.println();
                        System.out.print("Evaluation: Reached end of string with unmatched ");
                        while(!myStack.empty()){
                            System.out.print(myStack.pop() + " ");
                        }
                        System.out.println();
                        exit(-1);
                    }
                    break;
                }

                default:
                    System.out.println();
            }

            ++i;
        }
    }
}
