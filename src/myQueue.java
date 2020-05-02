public class myQueue {
	private String[] data;
	private int head;
	private int numElements;
	
	/* ********** Constructors ********** */
	public myQueue() {
		data = new String[10];
		init();
	}
	
	public myQueue(int size) {
		data = new String[size];
		init();
	}

	/**
	 * Initializes this instance's to be ready for use.
	 */
	private void init() {
		head = -1;
		numElements = 0;
	}
	
	/* ********** Operations ********** */
	/**
	 * Inserts the element into the top of the stack.
	 * @return true if the stack is not empty
	 */
	public boolean enqueue(String s) {
		if ( isFull() )
			return false;
		//is this the first insert?
		if ( isEmpty() )
			data[++head] = s;
		//otherwise, move the tail to the new position
		else
			data[(head+numElements)%data.length] = s;
		numElements++;
		return true;
	}

	/**
	 * Returns the element at the top of the stack (with removal).
	 * @return the element at the top of the stack, null if empty
	 */
	public String dequeue() {
		if ( isEmpty() )
			return null;
		String ret = data[head];
		numElements--;
		//was this the last item?
		if ( isEmpty() )
			init();
		//otherwise, move the head to the new position
		else
			head = (head+1)%data.length;
		return ret;
	}

	/**
	 * Returns the element at the top of the stack (without removal).
	 * @return the element at the top of the stack, null if empty
	 */
	public String peek() {
		return isEmpty() ? null : data[head];
	}

	/* ********** Status Monitors ********** */

	/**
	 * Returns the number of items currently in the stack.
	 * @return the number of elements in the list
	 */
	public int getSize() {
		return numElements;
	}

	/**
	 * Check whether the stack's data is empty.
	 * @return true if the top of the stack points to nothing
	 */
	public boolean isEmpty() {
		return numElements==0;
	}

	/**
	 * Check whether the stack is full.
	 * @return true if the top of the stack points to the max capacity
	 */
	public boolean isFull() {
		return numElements==data.length;
	}
}