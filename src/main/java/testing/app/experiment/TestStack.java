package testing.app.experiment;

import testing.lib.stack.QueueBySingleStack;
import testing.lib.stack.StackTest;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestStack {
    public static void run () {
        int size = 5;
        StackTest<Integer> stack1 = new StackTest<> ();
        for (int i = 0; i < size; i++) {
            stack1.push((int)(Math.random() * 9 + 1));
        }
        System.out.println("stack1: \n" + stack1);

        QueueBySingleStack<Integer> queueBySingleStack = new QueueBySingleStack<> ();
        for (int i = 0; i < size; i++) {
            int temp = (int)(Math.random() * 9 + 1);
            queueBySingleStack.enqueue(temp);
            System.out.print(temp + " -> ");
        }
        System.out.println(" null ");

        System.out.println("queueBySingleStack: \n" + queueBySingleStack.stack);
        System.out.println("queueBySingleStack.front() = " + queueBySingleStack.front());
        System.out.println("queueBySingleStack.end() = " + queueBySingleStack.end());
        int len = queueBySingleStack.length();
        for (int i = 0; i < len; i++) {
            queueBySingleStack.dequeue();
            System.out.println("queueBySingleStack: \n" + queueBySingleStack.stack);
        }

        StackTest<Integer> stack2 = new StackTest<> ();
        for (int i = 0; i < size; i++) {
            stack2.push((int)(Math.random() * 9 + 1));
        }
        System.out.println("stack2: \n" + stack2);
        stack2.sortStack();
        System.out.println("stack2 sorted: \n" + stack2);
    }
}
