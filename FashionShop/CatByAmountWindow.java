public class CatByAmountWindow extends ChildWindow {
	private CustomJTable tableObject;
	private ItemDetailRecord[] records;

	CatByAmountWindow () {
		this.records = CommonResources.orderManager.getItemDetails();

		this.sortRecordsByQTY();
		this.setWindowName("Items By Amount");
		this.buildLayout();
		this.pack();
	}

	private void buildLayout () {
		this.tableObject = new CustomJTable();
		this.tableObject.buildTable(new String[] { "Size", "QTY", "Amount" });
		this.tableObject.setHeight(9999);

		this.addComponent(this.tableObject.getTablePanel());
		this.updateTable();
	}

	private void sortRecordsByQTY () {
		int len = this.records.length;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (ItemDetailRecord.getAmount(this.records[j]) < ItemDetailRecord.getAmount(this.records[j + 1])) {
					ItemDetailRecord tmp = this.records[j];
					this.records[j] = this.records[j + 1];
					this.records[j + 1] = tmp;
				}
			}
		}
	}

	private void updateRecords () {
		this.tableObject.setRowCount(0);

		if (this.records == null || this.records.length == 0) return;
	
		for (ItemDetailRecord record : this.records) {
			this.tableObject.addRow(new Object[] {
				ItemDetailRecord.getSymbol(record),
				ItemDetailRecord.getQty(record),
				ItemDetailRecord.getAmount(record)
			});
		}
	
		this.tableObject.calculateSearchTableHeight();
	}

	private void updateTable () {
		this.updateRecords();
		this.pack();
	}

	public void windowClose () {
		CommonResources.forceToCloseCurrentWindow();
		CommonResources.setOpenedChildWindow(new ViewReportsWindow());
	}
}
