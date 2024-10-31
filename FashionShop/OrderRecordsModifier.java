public class OrderRecordsModifier {
	public static OrderRecord[] add (OrderRecord[] arr, OrderRecord item) {
		int len = arr.length;
		OrderRecord[] copy = new OrderRecord[len + 1];

		for (int i = 0; i < len; i++) {
			copy[i] = arr[i];
		}

		copy[len] = item;
		return copy;
	}

	public static String[] add (String[] arr, String item) {
		int len = arr.length;
		String[] copy = new String[len + 1];

		for (int i = 0; i < len; i++) {
			copy[i] = arr[i];
		}

		copy[len] = item;
		return copy;
	}

	public static OrderRecord[] remove (OrderRecord[] arr, OrderRecord item) {
		int len = arr.length;
		int offset = 0;
		OrderRecord[] copy = new OrderRecord[len - 1];

		for (int i = 0; i < len; i++) {
			if (arr[i] == item) {
				offset = 1;
			} else {
				copy[i - offset] = arr[i];
			}
		}

		copy[len] = item;
		return copy;
	}
}
