class Main {
	public static void main (String[] args) {
		importSaveData();
		new MainWindow();
	}

	public static void importSaveData () {
		String[] records = CommonResources.fileManager.read();
		int maximumOrderID = 1;
		OrderManager manager = CommonResources.orderManager;

		for (String record : records) {
			String[] data = record.split(",");
			int id = Integer.parseInt(data[0]);
			String customer = data[1];
			int sizeIndex = Integer.parseInt(data[2]);
			int qty = Integer.parseInt(data[3]);
			int status = Integer.parseInt(data[4]);

			if (id > maximumOrderID) maximumOrderID = id;

			manager.add(id, customer, sizeIndex, qty, status);
		}

		manager.setCurrentOrderID(maximumOrderID + 1);
	}
}
