public class OrderRecord {
	public final static String[] SIZES = { "XS", "S", "M", "L", "XL", "XXL" };
	public final static double[] PRICES = { 600.0, 800.0, 900.0, 1000.0, 1100.0, 1200.0 };
	public final static String[] STATUSES = { "Processing", "Delivering", "Delivered" };

	private int sizeIndex;
	private int qty;
	private int id;
	private String customer;
	private int status;

	OrderRecord (int id, String customer, int sizeIndex, int qty) {
		this.id = id;
		this.customer = customer;
		this.sizeIndex = sizeIndex;
		this.qty = qty;
		this.status = 0;
	}

	OrderRecord (int id, String customer, int sizeIndex, int qty, int status) {
		this.id = id;
		this.customer = customer;
		this.sizeIndex = sizeIndex;
		this.qty = qty;
		this.status = status;
	}

	public static int getID (OrderRecord record) {
		return record.id;
	}

	public static int getSizeIndex (OrderRecord record) {
		return record.sizeIndex;
	}

	public static int getSizeIndex (String size) {
		for (int i = 0; i < SIZES.length; i++) {
			if (size.toUpperCase().equals(SIZES[i])) return i;
		}

		return -1;
	}

	public static String getSize (OrderRecord record) {
		return SIZES[record.sizeIndex];
	}

	public static int getQTY (OrderRecord record) {
		return record.qty;
	}

	public static double getAmount (OrderRecord record) {
		return PRICES[record.sizeIndex] * record.qty;
	}

	public static double getAmount (int sizeIndex, int qty) {
		return PRICES[sizeIndex] * qty;
	}

	public static String getCustomer (OrderRecord record) {
		return record.customer;
	}

	public static String getStatus (OrderRecord record) {
		return OrderRecord.STATUSES[record.status];
	}

	public static void setStatus (OrderRecord record, int status) {
		record.status = status;
	}

	// public static String idToString (int id) {
	// 	return String.format("ODR#%05d", id);
	// }

	// public static int stringToID (String id) {
	// 	if (!id.matches("^ODR#\\d{5}$")) return -1; // Invalid ID String pattern. (ODR#00001)

	// 	id = id.replace("ODR#", "");
	// 	return Integer.parseInt(id);
	// }

	public String toString () {
		return String.format("%d,%s,%d,%d,%d", this.id, this.customer, this.sizeIndex, this.qty, this.status);
	}
}
