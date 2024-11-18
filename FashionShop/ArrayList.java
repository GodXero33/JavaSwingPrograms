public class ArrayList {
	private OrderRecord[] list;
	private int length;
	private double fact;
	private int initalSize;

	ArrayList (int initalSize, double fact) {
		if (initalSize < 1) initalSize = 1;

		this.fact = fact;
		this.list = new OrderRecord[initalSize];
		this.initalSize = initalSize;
	}

	ArrayList (int initalSize) {
		this(initalSize, 0.5);
	}

	ArrayList () {
		this(10, 0.5);
	}

	// Grow the source array by (1 + fact). If current length of the array is 10 and the fact is 0.5, then new array length is 15(10 * (1 + 0.5)).
	private void grow () {
		int newSize = (int) (this.list.length * (1 + this.fact));
		OrderRecord[] tmpList = new OrderRecord[newSize];

		for (int i = 0; i < this.length; i++) {
			tmpList[i] = this.list[i];
		}

		this.list = tmpList;
	}

	// Shrink the source array by 'fact' and add 1. If current length of the array is 15 and fact is 0.5, then new array length is 8((int) (15 * 0.5) + 1 = (int) 7.5 + 1 = 7 + 1 = 8).
	private void shrink () {
		int newSize = (int) (this.list.length * this.fact) + 1;
		OrderRecord[] tmpList = new OrderRecord[newSize];

		for (int i = 0; i < this.length; i++) {
			tmpList[i] = this.list[i];
		}

		this.list = tmpList;
	}

	// Check if the arrays needs to shrink or not.
	private void checkShrink () {
		if (this.length < (int) (this.list.length * this.fact) + 1) {
			this.shrink();
		}
	}

	// Get the length of the list.
	public int size () {
		return this.length;
	}

	// Reduce the length of the list.
	public void setSize (int size) {
		if (size < 0 || size >= this.length) return;

		if (size == 0) {
			this.clear();
			return;
		}

		this.length = size;
	}

	/**
	 * Append a data at end of the list.
	 * @param data is the value that needs to append.
	 */
	public void append (OrderRecord data) {
		if (this.length + 1 > this.list.length) this.grow();

		this.list[this.length] = data;
		this.length++;
	}

	/**
	 * Insert a data at specific location of the list.
	 * @param index is the location that data needs to insert.
	 * @param data is the value that needs to insert.
	 */
	public void insert (int index, OrderRecord data) {
		if (index < 0 || index > this.length - 1) return;
		if (this.length + 1 > this.list.length) this.grow();

		OrderRecord prev = this.list[index];
		this.list[index] = data;

		for (int i = index + 1; i < this.length + 1; i++) {
			OrderRecord tmpPrev = this.list[i];
			this.list[i] = prev;
			prev = tmpPrev;
		}

		this.length++;
	}

	/**
	 * Remove a specific data from the list. The first occurrence of the larget data will be removed.
	 * @param data is the value that needs to remove from the list.
	 */
	public void remove (OrderRecord data) {
		this.pop(this.indexOf(data));
	}

	/**
	 * Remove a data from specific location in the list and return that removed data.
	 * @param index is the location that needs to remove data.
	 * @return the value of the removed data.
	 */
	public OrderRecord pop (int index) {
		if (index < 0 || index >= this.length) return null;

		OrderRecord data = this.list[index];
		OrderRecord next = this.list[index + 1];

		for (int i = index; i < this.length - 1; i++) {
			this.list[i] = next;
			next = this.list[i + 2];
		}

		this.length--;
		this.checkShrink();
		return data;
	}

	// Remove very last data from the list and return the value of removed data.
	public OrderRecord pop () {
		return this.pop(this.length - 1);
	}

	// Clear the list.
	public void clear () {
		this.list = new OrderRecord[this.initalSize];
		this.length = 0;
	}

	/**
	 * Get the location of first occurrence of a specific data.
	 * @param data is the value that needs to search
	 * @return the index of first occurrence of the target data. If there is no data found then return -1.
	 */
	public int indexOf (OrderRecord data) {
		for (int i = 0; i < this.length; i++) {
			if (this.list[i] == data) return i;
		}

		return -1;
	}

	/**
	 * Get total count of a specific data repeated in the list.
	 * @param data is the value that needs to search.
	 * @return the count of target data.
	 */
	public int count (OrderRecord data) {
		int counter = 0;

		for (int i = 0; i < this.length; i++) {
			if (this.list[i] == data) counter++;
		}

		return counter;
	}

	// Get a shallow copy of the list.
	public ArrayList copy () {
		ArrayList list = new ArrayList(this.initalSize, this.fact);

		for (int i = 0; i < this.length; i++) {
			list.append(this.list[i]);
		}

		return list;
	}

	// Reverses the order of datas in the list.
	public void reverse () {
		for (int i = 0; i < this.length / 2; i++) {
			OrderRecord tmpOrder = this.list[i];
			this.list[i] = this.list[this.length - i - 1];
			this.list[this.length - i - 1] = tmpOrder;
		}
	}

	/**
	 * Update the value of a data in specific location.
	 * @param index is the location that needs to update.
	 * @param data is the new value of the target data.
	 */
	public void set (int index, OrderRecord data) {
		if (index < 0 || index > this.length - 1) return;
		this.list[index] = data;
	}

	/**
	 * Get the value of a data in specific location.
	 * @param index is the location of the data that needs to get the value.
	 * @return the value of target data. If index is out of bounds returns -1.
	 */
	public OrderRecord get (int index) {
		if (index < 0 || index > this.length - 1) return null;
		return this.list[index];
	}

	// Check if the list is empty or not. If list is empty returns 'true', otherwise 'false'.
	public boolean isEmpty () {
		return this.length == 0;
	}

	// Convert the list into an Array.
	public OrderRecord[] toArray () {
		OrderRecord[] arr = new OrderRecord[this.length];

		for (int i = 0; i < this.length; i++) {
			arr[i] = this.list[i];
		}

		return arr;
	}

	// Convert the list into a plain text(String).
	// public String toString () {
	// 	if (this.length == 0) return "<>";

	// 	StringBuilder builder = new StringBuilder();
	// 	builder.append('<');

	// 	for (int i = 0; i < this.length; i++) {
	// 		builder.append(this.list[i]);

	// 		if (i != this.length - 1) builder.append(", ");
	// 	}

	// 	builder.append('>');
	// 	return builder.toString();
	// }
}
