package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {


        MyStack stack = new MyStack();

        stack.pushNode(7);;

        stack.pushNode(79);
        stack.pushNode(0);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.pushNode(5);
        stack.printStack();
        recursivePrint(1000);
        String temp = "StackOverFlow";


    }

    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);
        if(num == 0)
            return;
        else
            recursivePrint(++num);
    }

    public static String reverseString(String input) {
        String current = "";
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < input.length() ; i++) {
            characterStack.push(input.charAt(i));
        }

        while (!characterStack.isEmpty()) {
            current += characterStack.pop();
        }
        return current;
    }

}
