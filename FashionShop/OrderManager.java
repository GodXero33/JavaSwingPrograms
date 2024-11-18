import java.util.HashMap;
import java.util.Set;

public class OrderManager {
	public final static int ADD_RECORD_SUCCESS = 0;
	public final static int ADD_RECORD_INVALID_PHONE = 1;
	public final static int ADD_RECORD_INVALID_SIZE = 2;
	public final static int ADD_RECORD_INVALID_QTY = 3;
	public final static int REMOVE_RECORD_SUCCESS = 0;
	public final static int REMOVE_RECORD_FAILED = 1;

	private ArrayList orderRecords;
	private int currentOrderID = 1;

	OrderManager () {
		this.orderRecords = new ArrayList(20, 1);
	}

	public OrderRecord[] getOrderRecords () {
		// I should return a copy of 'orderRecords'. But in this case it's not neccessary. So I just return original array. :)
		return this.orderRecords.toArray();
	}

	public int add (int id, String customer, String size, String qty) {
		if (!OrderRecordVilidater.isValidPhone(customer)) return OrderManager.ADD_RECORD_INVALID_PHONE;
		if (!OrderRecordVilidater.isValidSize(size)) return OrderManager.ADD_RECORD_INVALID_SIZE;
		if (!OrderRecordVilidater.isValidQTY(qty)) return OrderManager.ADD_RECORD_INVALID_QTY;

		OrderRecord newRecord = new OrderRecord(id, customer, OrderRecord.getSizeIndex(size), Integer.parseInt(qty));
		this.orderRecords.append(newRecord);
		this.currentOrderID++;
		return OrderManager.ADD_RECORD_SUCCESS;
	}

	public void add (int id, String customer, int sizeIndex, int qty, int status) {
		this.orderRecords.append(new OrderRecord(id, customer, sizeIndex, qty, status));
	}

	public int remove (int id) {
		int recordIndex = -1;
		OrderRecord matchRecord = null;
		
		for (int i = 0; i < this.orderRecords.size(); i++) {
			OrderRecord currentRecord = this.orderRecords.get(i);

			if (OrderRecord.getID(currentRecord) == id) {
				recordIndex = i;
				matchRecord = currentRecord;
				break;
			}
		}

		if (recordIndex == -1) return OrderManager.REMOVE_RECORD_FAILED;

		this.orderRecords.remove(matchRecord);
		return OrderManager.REMOVE_RECORD_SUCCESS;
	}

	public int remove (OrderRecord record) {
		int recordIndex = -1;
		
		for (int i = 0; i < this.orderRecords.size(); i++) {
			OrderRecord currentRecord = this.orderRecords.get(i);

			if (currentRecord == record) {
				recordIndex = i;
				break;
			}
		}
		
		if (recordIndex == -1) return OrderManager.REMOVE_RECORD_FAILED;

		this.orderRecords.remove(record);
		return OrderManager.REMOVE_RECORD_SUCCESS;
	}

	public OrderRecord[] search (String customer) {
		int matchCount = 0;
		OrderRecord[] orderRecordsArray = this.orderRecords.toArray();

		for (OrderRecord record : orderRecordsArray) {
			if (OrderRecord.getCustomer(record).equals(customer)) {
				matchCount++;
			}
		}

		if (matchCount == 0) return null;

		OrderRecord[] searchData = new OrderRecord[matchCount];
		int counter = 0;

		for (OrderRecord record : orderRecordsArray) {
			if (OrderRecord.getCustomer(record).equals(customer)) {
				searchData[counter] = record;
				counter++;
			}
		}

		return searchData;
	}

	public OrderRecord search (int id) {
		OrderRecord[] orderRecordsArray = this.orderRecords.toArray();

		for (OrderRecord record : orderRecordsArray) {
			if (OrderRecord.getID(record) == id) return record;
		}

		return null;
	}

	public int getNextOrderID () {
		return this.currentOrderID;
	}

	public void setCurrentOrderID (int id) {
		this.currentOrderID = id;
	}

	public boolean save () {
		String text = "";
		OrderRecord[] orderRecordsArray = this.orderRecords.toArray();

		for (OrderRecord record : orderRecordsArray) {
			text += record.toString() + "\n";
		}

		return CommonResources.fileManager.save(text);
	}

	public TotalOrderRecord[] getCustomersTotalOrderRecords () {
		HashMap<String, TotalOrderRecord> customersMap = new HashMap<>();
		OrderRecord[] orderRecordsArray = this.orderRecords.toArray();

		for (OrderRecord record : orderRecordsArray) {
			String phone = OrderRecord.getCustomer(record);
			int qty = OrderRecord.getQTY(record);
			double amount = OrderRecord.getAmount(record);

			if (customersMap.containsKey(phone)) {
				TotalOrderRecord.add(customersMap.get(phone), qty, amount);
			} else {
				customersMap.put(phone, new TotalOrderRecord(phone, qty, amount));
			}
		}

		Set<String> keys = customersMap.keySet();
		TotalOrderRecord[] output = new TotalOrderRecord[keys.size()];
		int i = 0;

		for (String key : keys) {
			output[i] = customersMap.get(key);
			i++;
		}

		return output;
	}

	public DetailedOrderRecord[] getCustomersDetailedOrderRecords () {
		HashMap<String, DetailedOrderRecord> customersMap = new HashMap<>();
		OrderRecord[] orderRecordsArray = this.orderRecords.toArray();

		for (OrderRecord record : orderRecordsArray) {
			String phone = OrderRecord.getCustomer(record);
			int qty = OrderRecord.getQTY(record);
			int sizeIndex = OrderRecord.getSizeIndex(record);
			double amount = OrderRecord.getAmount(record);

			if (customersMap.containsKey(phone)) {
				DetailedOrderRecord.add(customersMap.get(phone), qty, sizeIndex, amount);
			} else {
				int[] qtys = new int[6];
				qtys[sizeIndex] = qty;
				customersMap.put(phone, new DetailedOrderRecord(phone, qtys, amount));
			}
		}

		Set<String> keys = customersMap.keySet();
		DetailedOrderRecord[] output = new DetailedOrderRecord[keys.size()];
		int i = 0;

		for (String key : keys) {
			output[i] = customersMap.get(key);
			i++;
		}

		return output;
	}

	public ItemDetailRecord[] getItemDetails () {
		ItemDetailRecord[] itemRecords = new ItemDetailRecord[6];

		for (int i = 0; i < 6; i++) {
			itemRecords[i] = new ItemDetailRecord(OrderRecord.SIZES[i]);
		}

		for (int i = 0; i < this.orderRecords.size(); i++) {
			OrderRecord record = this.orderRecords.get(i);
			int sizeIndex = OrderRecord.getSizeIndex(record);
			int qty = OrderRecord.getQTY(record);
			double amount = OrderRecord.getAmount(record);

			ItemDetailRecord.add(itemRecords[sizeIndex], qty, amount);
		}

		return itemRecords;
	}
}
