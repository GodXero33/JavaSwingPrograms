public class ItemDetailRecord {
	private String symbol;
	private int qty;
	private double amount;

	ItemDetailRecord (String symbol) {
		this.symbol = symbol;
	}

	public static String getSymbol (ItemDetailRecord record) {
		return record.symbol;
	}

	public static int getQty (ItemDetailRecord record) {
		return record.qty;
	}

	public static double getAmount (ItemDetailRecord record) {
		return record.amount;
	}

	public static void add (ItemDetailRecord record, int qty, double amount) {
		record.qty += qty;
		record.amount += amount;
	}
}
