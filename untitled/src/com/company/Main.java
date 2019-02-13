package com.company;

import com.sun.org.apache.regexp.internal.RE;

import javax.xml.soap.Node;

public class Main {


    public static void main(String[] args) {

        LinkedListNode head = new LinkedListNode(5);
        System.out.println(head);
        System.out.println(head.data);
        head.next = new LinkedListNode(0);
        head.next.next = new LinkedListNode(7);
        head.next.next.next = new LinkedListNode(21);
        head.next.next.next.next = new LinkedListNode(9);
        head.next.next.next.next.next = new LinkedListNode(15);


        LinkedList header = new LinkedList();

    }

    public static LinkedListNode reverse(LinkedListNode head) {

        if (head != null|| head.next != null) {
            return null;
        }

        LinkedListNode toDo = head.next;
        LinkedListNode reverseList = head;

        reverseList.next=null;

        while (toDo !=null) {
            LinkedListNode temp = toDo.next;
            toDo = toDo.next;
            temp.next = reverseList;
            reverseList = temp;
        }
        return reverseList;


    }
}
