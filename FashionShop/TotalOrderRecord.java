public class TotalOrderRecord {
	private String customer;
	private int qty;
	private double amount;

	TotalOrderRecord (String customer, int qty, double amount) {
		this.customer = customer;
		this.qty = qty;
		this.amount = amount;
	}

	public static String getCustomer (TotalOrderRecord record) {
		return record.customer;
	}

	public static int getQTY (TotalOrderRecord record) {
		return record.qty;
	}

	public static double getAmount (TotalOrderRecord record) {
		return record.amount;
	}

	public static void add (TotalOrderRecord record, int qty, double amount) {
		record.qty += qty;
		record.amount += amount;
	}
}
