public class OrderManager {
	public final static int ADD_RECORD_SUCCESS = 0;
	public final static int ADD_RECORD_INVALID_PHONE = 1;
	public final static int ADD_RECORD_INVALID_SIZE = 2;
	public final static int ADD_RECORD_INVALID_QTY = 3;
	public final static int REMOVE_RECORD_SUCCESS = 0;
	public final static int REMOVE_RECORD_FAILED = 1;

	private OrderRecord[] orderRecords;
	private int currentOrderID = 1;

	OrderManager () {
		this.orderRecords = new OrderRecord[0];
	}

	public int add (int id, String customer, String size, String qty) {
		if (!OrderRecordVilidater.isValidPhone(customer)) return OrderManager.ADD_RECORD_INVALID_PHONE;
		if (!OrderRecordVilidater.isValidSize(size)) return OrderManager.ADD_RECORD_INVALID_SIZE;
		if (!OrderRecordVilidater.isValidQTY(qty)) return OrderManager.ADD_RECORD_INVALID_QTY;

		OrderRecord newRecord = new OrderRecord(id, customer, OrderRecord.getSizeIndex(size), Integer.parseInt(qty));
		this.orderRecords = OrderRecordsModifier.add(this.orderRecords, newRecord);
		this.currentOrderID++;
		return OrderManager.ADD_RECORD_SUCCESS;
	}

	public void add (int id, String customer, int sizeIndex, int qty) {
		OrderRecord newRecord = new OrderRecord(id, customer, sizeIndex, qty);
		this.orderRecords = OrderRecordsModifier.add(this.orderRecords, newRecord);
	}

	public int remove (int id) {
		int recordIndex = -1;
		
		for (int i = 0; i < this.orderRecords.length; i++) {
			if (OrderRecord.getID(this.orderRecords[i]) == id) {
				recordIndex = i;
				break;
			}
		}

		if (recordIndex == -1) return OrderManager.REMOVE_RECORD_FAILED;

		this.orderRecords = OrderRecordsModifier.remove(this.orderRecords, this.orderRecords[recordIndex]);
		return OrderManager.REMOVE_RECORD_SUCCESS;
	}

	public OrderRecord[] search (String customer) {
		int matchCount = 0;

		for (OrderRecord record : this.orderRecords) {
			if (OrderRecord.getCustomer(record).equals(customer)) {
				matchCount++;
			}
		}

		if (matchCount == 0) return null;

		OrderRecord[] searchData = new OrderRecord[matchCount];
		int counter = 0;

		for (OrderRecord record : this.orderRecords) {
			if (OrderRecord.getCustomer(record).equals(customer)) {
				searchData[counter] = record;
				counter++;
			}
		}

		return searchData;
	}

	public int getNextOrderID () {
		return this.currentOrderID;
	}

	public void setCurrentOrderID (int id) {
		this.currentOrderID = id;
	}

	public boolean save () {
		String text = "";

		for (OrderRecord record : this.orderRecords) {
			text += record.toString() + "\n";
		}

		return CommonResources.fileManager.save(text);
	}
}
