package com.example.stl.queues;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
public class implementQueueUsingStacks   {

    /* two stacks - stack1 and stack2 */
    private Stack stack1 = new Stack  ();
    private Stack stack2 = new Stack  ();

    /* Enqueue - add the element in stack1 */
    public void enqueue(int element) {
        stack1.push(element);
    }

    /* Dequeue - remove the element from stack2 */
    public void dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        }
    }
        return stack2.();


}