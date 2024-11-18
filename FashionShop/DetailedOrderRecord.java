public class DetailedOrderRecord {
	private String customer;
	private int[] qtys;
	private double amount;

	DetailedOrderRecord (String customer, int[] qtys, double amount) {
		this.customer = customer;
		this.qtys = qtys;
		this.amount = amount;
	}

	public static String getCustomer (DetailedOrderRecord record) {
		return record.customer;
	}

	public static int getQTY (DetailedOrderRecord record, int index) {
		return record.qtys[index];
	}

	public static double getAmount (DetailedOrderRecord record) {
		return record.amount;
	}

	public static void add (DetailedOrderRecord record, int qty, int qtyIndex, double amount) {
		record.qtys[qtyIndex] += qty;
		record.amount += amount;
	}
}
