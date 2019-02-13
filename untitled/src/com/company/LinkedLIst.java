package com.company;


    class LinkedList {

        static Node head;

        static class Node {

            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        // A simple and tail recursive function to reverse
        // a linked list.  prev is passed as NULL initially.
        Node reverseUtil(Node curr, Node prev) {

            /* If last node mark it head*/
            if (curr.next == null) {
                head = curr;

                /* Update next to prev node */
                curr.next = prev;
                return null;
            }

            /* Save curr->next node for recursive call */
            Node next1 = curr.next;

            /* and update next ..*/
            curr.next = prev;

            reverseUtil(next1, curr);
            return head;
        }

        // prints content of double linked list
        void printList(Node node) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
    }
