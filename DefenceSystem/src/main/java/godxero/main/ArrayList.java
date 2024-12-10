/**
 * 
 * I just took my own ArrayList class. Why not right? I mean it's the same. Although, I have full idea here what's going on. And here, there only necessary methods are declaired.
 * 
 */

package godxero.main;

public class ArrayList<G> {
	private G[] list;
	private int length;
	private double fact;
	private int initalSize;

	public ArrayList (int initalSize, double fact) {
		if (initalSize < 1) initalSize = 1;

		this.fact = fact;
		this.list = this.newArray(initalSize);
		this.initalSize = initalSize;
	}

	public ArrayList (int initalSize) {
		this(initalSize, 0.5);
	}

	public ArrayList () {
		this(10, 0.5);
	}

	@SuppressWarnings("unchecked")
	private G[] newArray (int length) {
		return (G[]) new Object[length];
	}

	private void grow () {
		int newSize = (int) (this.list.length * (1 + this.fact));
		G[] tmpList = this.newArray(newSize);

		for (int i = 0; i < this.length; i++) {
			tmpList[i] = this.list[i];
		}

		this.list = tmpList;
	}

	/* private void shrink () {
		int newSize = (int) (this.list.length * this.fact) + 1;
		G[] tmpList = this.newArray(newSize);

		for (int i = 0; i < this.length; i++) {
			tmpList[i] = this.list[i];
		}

		this.list = tmpList;
	} */

	/* private void checkShrink () {
		if (this.length < (int) (this.list.length * this.fact) + 1) {
			this.shrink();
		}
	} */

	public int size () {
		return this.length;
	}

	public void setSize (int size) {
		if (size < 0 || size >= this.length) return;

		if (size == 0) {
			this.clear();
			return;
		}

		this.length = size;
	}

	public void append (G data) {
		if (this.length + 1 > this.list.length) this.grow();

		this.list[this.length] = data;
		this.length++;
	}

	/* public void insert (int index, G data) {
		if (index < 0 || index > this.length - 1) return;
		if (this.length + 1 > this.list.length) this.grow();

		G prev = this.list[index];
		this.list[index] = data;

		for (int i = index + 1; i < this.length + 1; i++) {
			G tmpPrev = this.list[i];
			this.list[i] = prev;
			prev = tmpPrev;
		}

		this.length++;
	} */

	/* public void remove (G data) {
		this.pop(this.indexOf(data));
	} */

	/* public G pop (int index) {
		if (index < 0 || index >= this.length) return null;

		G data = this.list[index];
		G next = this.list[index + 1];

		for (int i = index; i < this.length - 1; i++) {
			this.list[i] = next;
			next = this.list[i + 2];
		}

		this.length--;
		this.checkShrink();
		return data;
	} */

	/* public G pop () {
		return this.pop(this.length - 1);
	} */

	public void clear () {
		this.list = this.newArray(this.initalSize);
		this.length = 0;
	}

	/* public int indexOf (G data) {
		for (int i = 0; i < this.length; i++) {
			if (this.list[i] == data) return i;
		}

		return -1;
	} */

	/* public int count (G data) {
		int counter = 0;

		for (int i = 0; i < this.length; i++) {
			if (this.list[i] == data) counter++;
		}

		return counter;
	} */

	/* public ArrayList<G> copy () {
		ArrayList<G> list = new ArrayList<>(this.initalSize, this.fact);

		for (int i = 0; i < this.length; i++) {
			list.append(this.list[i]);
		}

		return list;
	} */

	/* public void reverse () {
		for (int i = 0; i < this.length / 2; i++) {
			G tmp = this.list[i];
			this.list[i] = this.list[this.length - i - 1];
			this.list[this.length - i - 1] = tmp;
		}
	} */

	/* public void set (int index, G data) {
		if (index < 0 || index > this.length - 1) return;
		this.list[index] = data;
	} */

	public G get (int index) {
		if (index < 0 || index > this.length - 1) return null;
		return this.list[index];
	}

	/* public boolean isEmpty () {
		return this.length == 0;
	} */

	/* public G[] toArray () {
		G[] arr = this.newArray(this.length);

		for (int i = 0; i < this.length; i++) {
			arr[i] = this.list[i];
		}

		return arr;
	} */

	@Override
	public String toString () {
		if (this.length == 0) return "<>";

		StringBuilder builder = new StringBuilder();
		builder.append('<');

		for (int i = 0; i < this.length; i++) {
			builder.append(this.list[i]);

			if (i != this.length - 1) builder.append(", ");
		}

		builder.append('>');
		return builder.toString();
	}
}
