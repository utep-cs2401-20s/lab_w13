public class myStack {
	private String[] data;
	private int top;
	
	/* ********** Constructors ********** */
	public myStack() {
		data = new String[10];
		top = -1;
	}
	
	public myStack(int size) {
		data = new String[size];
		top = -1;
	}
	
	/* ********** Operations ********** */
	/**
	 * Inserts the element into the top of the stack.
	 * @return true if the stack is not empty
	 */
	public boolean push(String s) {
		if ( isFull() )
			return false;
		data[++top] = s;
		return true;
	}

	/**
	 * Returns the element at the top of the stack (with removal).
	 * @return the element at the top of the stack, null if empty
	 */
	public String pop() {
		return isEmpty() ? null : data[top--];
	}

	/**
	 * Returns the element at the top of the stack (without removal).
	 * @return the element at the top of the stack, null if empty
	 */
	public String peek() {
		return isEmpty() ? null : data[top];
	}

	/* ********** Status Monitors ********** */

	/**
	 * Returns the number of items currently in the stack.
	 * @return the number of elements in the list
	 */
	public int getSize() {
		return top+1;
	}

	/**
	 * Check whether the stack's data is empty.
	 * @return true if the top of the stack points to nothing
	 */
	public boolean isEmpty() {
		return top==-1;
	}

	/**
	 * Check whether the stack is full.
	 * @return true if the top of the stack points to the max capacity
	 */
	public boolean isFull() {
		return top==data.length-1;
	}
}