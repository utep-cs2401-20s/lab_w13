import static org.junit.jupiter.api.Assertions.*;

public class StackQueueTester {
    myStack stack;
    myQueue queue;
    String[] list = new String[]{"hello","HELLO","12345"};

    /**
     * Test case to check whether the constructor creates the instance.
     *
     * Input(s):
     *  - a stack is created of max capacity 3
     *  - a queue is created of max capacity 3
     *
     * Expected output(s):
     *  - an empty stack is created of max capacity 3
     *  - an empty queue is created of max capacity 3
     */
    @org.junit.jupiter.api.Test
    void constructors() {
        stack = new myStack(3);
        assertEquals(0,stack.getSize());
        assertTrue(stack.isEmpty());
        queue = new myQueue(3);
        assertEquals(0,queue.getSize());
        assertTrue(queue.isEmpty());
    }

    /**
     * Test case to check whether the insertion methods insert til full.
     *
     * Input(s):
     *  - a stack is created of max capacity 3
     *    pushing strings: "hello", "HELLO", "12345", and ""
     *  - a queue is created of max capacity 3
     *    enqueue-ing strings: "hello", "HELLO", "12345", and ""
     *
     * Expected output(s):
     *  - an empty stack is filled to max capacity, and cannot push any further
     *  - an empty queue is filled to max capacity, and cannot enqueue any further
     */
    @org.junit.jupiter.api.Test
    void inserts() {
        stack = new myStack(3);
        queue = new myQueue(3);

        //fill the data structures
        int i=-1;
        while ( ++i<list.length ) {
            assertTrue(stack.push(list[i]));
            assertTrue(queue.enqueue(list[i]));
        }

        assertEquals(list.length,stack.getSize());
        assertTrue(stack.isFull());
        assertFalse(stack.push(""));
        assertEquals(list.length,stack.getSize());
        assertTrue(queue.isFull());
        assertFalse(queue.enqueue(""));
    }

    /**
     * Test case to check whether the removal methods remove til empty.
     *
     * Input(s):
     *  - a stack is created of max capacity 3
     *    pushing strings: "hello", "HELLO", and "12345"
     *  - a queue is created of max capacity 3
     *    pushing strings: "hello", "HELLO", and "12345"
     *
     * Expected output(s):
     *  - an full stack is emptied (in reverse order) and cannot pop any further
     *  - an full queue is emptied (in correct order) and cannot dequeue any further
     */
    @org.junit.jupiter.api.Test
    void removes() {
        stack = new myStack(3);
        queue = new myQueue(3);

        //fill the data structures
        int i=-1;
        while ( ++i<list.length ) {
            stack.push(list[i]);
            queue.enqueue(list[i]);
        }

        int S=list.length-1, Q=0;
        while ( Q<list.length && S>=0 ) {
            assertEquals(list[S--],stack.pop()); //reverse order
            assertEquals(list[Q++],queue.dequeue()); //inserted order
        }

        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
        assertTrue(queue.isEmpty());
        assertNull(queue.dequeue());
    }

    /**
     * Test case to check whether the peek methods do not remove.
     *
     * Input(s):
     *  - a stack is created of max capacity 3, that contains only one string ("HELLO")
     *  - a queue is created of max capacity 3, that contains only one string ("HELLO")
     *
     * Expected output(s):
     *  - the stack is peeked without removal ("HELLO")
     *    and the stack is emptied (pop once) and cannot be peeked
     *  - the queue is peeked without removal ("HELLO")
     *    and the queue is emptied (dequeue once) and cannot be peeked
     */
    @org.junit.jupiter.api.Test
    void peeks() {
        stack = new myStack(3);
        queue = new myQueue(3);

        stack.push(list[1]);
        queue.enqueue(list[1]);

        assertEquals(list[1],stack.peek());
        stack.pop();
        assertNull(stack.peek());
        assertEquals(list[1],queue.peek());
        queue.dequeue();
        assertNull(queue.peek());
    }
}