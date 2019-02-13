package com.company;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack {

   private StackNode top;

    public MyStack() {
        top = null;

    }

    public void pushNode(int data) {
        if (top == null) {
            top = new StackNode(data);
            return;


        }

        StackNode temp = new StackNode(data);
        temp.next = top;
        top = temp;
    }


    public StackNode pop() {
        StackNode temp = top.next;
        top = temp;
        //or top = top.next
        if (top==null) {
            throw new EmptyStackException();
        }
        StackNode temp1 = top;
        top = top.next;
        return temp;


    }

    public int peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }

    public StackNode getTop() {
        return top;
    }

    public void printStack() {
        StackNode temp = top;

        while (temp!= null) {
            System.out.println(temp.data);
            temp = temp.next;
        }


    }


}
