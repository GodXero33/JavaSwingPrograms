import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class AllCustomersWindow extends ChildWindow {
	private int tableIndex = 0;
	private int maxPagesCount = 0;
	private CustomJTable tableObject;
	private CustomJButton prevBtn;
	private CustomJButton nextBtn;
	private DetailedOrderRecord[] records;
	private DetailedOrderRecord[] tableRecords;

	AllCustomersWindow () {
		this.records = CommonResources.orderManager.getCustomersDetailedOrderRecords();
		this.maxPagesCount = records.length / CommonResources.maxTableRowCount + 1;

		this.setWindowName("All Customers");
		this.buildLayout();
		this.addCustomEvents();
		this.pack();
	}

	private void buildLayout () {
		this.tableObject = new CustomJTable();
		this.tableObject.buildTable(new String[] { "Customer", "XS", "S", "M", "L", "XL", "XXL", "Amount" });
		this.tableObject.setWidth(1000);

		JPanel btnsPanel = new JPanel(new GridLayout(1, 2, CommonResources.btnsGap, CommonResources.btnsGap));
		btnsPanel.setBorder(CommonResources.padding2);
		btnsPanel.setBackground(CommonResources.bgColor2);

		this.prevBtn = new CustomJButton("Prev");
		this.nextBtn = new CustomJButton("Next");

		btnsPanel.add(this.prevBtn);
		btnsPanel.add(this.nextBtn);

		this.addComponent(this.tableObject.getTablePanel());
		this.addComponent(btnsPanel);

		this.updateTable();
	}

	private void updateTableRecords () {
		int len = 0;

		if (this.tableIndex == this.maxPagesCount - 1) {
			len = this.records.length % CommonResources.maxTableRowCount;
		} else {
			len = 20;
		}

		DetailedOrderRecord[] tmpRecords = new DetailedOrderRecord[len];
		int startOffset = this.tableIndex * CommonResources.maxTableRowCount;

		for (int i = 0; i < len; i++) {
			tmpRecords[i] = this.records[startOffset + i];
		}

		this.tableRecords = tmpRecords;
	}

	private void updateRecords () {
		this.tableObject.setRowCount(0);

		if (this.tableRecords == null || this.tableRecords.length == 0) return;
	
		for (DetailedOrderRecord record : this.tableRecords) {
			this.tableObject.addRow(new Object[] {
				DetailedOrderRecord.getCustomer(record),
				DetailedOrderRecord.getQTY(record, 0),
				DetailedOrderRecord.getQTY(record, 1),
				DetailedOrderRecord.getQTY(record, 2),
				DetailedOrderRecord.getQTY(record, 3),
				DetailedOrderRecord.getQTY(record, 4),
				DetailedOrderRecord.getQTY(record, 5),
				DetailedOrderRecord.getAmount(record)
			});
		}
	
		this.tableObject.calculateSearchTableHeight();
	}

	private void updateTable () {
		if (this.tableIndex == 0) {
			this.prevBtn.disableBtn();
		} else if (this.tableIndex == this.maxPagesCount - 1) {
			this.nextBtn.disableBtn();
		} else {
			this.prevBtn.enableBtn();
			this.nextBtn.enableBtn();
		}

		this.updateTableRecords();
		this.updateRecords();
		this.pack();
	}

	private void prevPage () {
		this.tableIndex--;

		if (this.tableIndex >= 0) {
			this.updateTable();
		}
	}

	private void nextPage () {
		this.tableIndex++;

		if (this.tableIndex <= this.maxPagesCount - 1) {
			this.updateTable();
		}
	}

	public void windowClose () {
		CommonResources.forceToCloseCurrentWindow();
		CommonResources.setOpenedChildWindow(new ViewReportsWindow());
	}

	private void addCustomEvents () {
		AllCustomersWindow thisInstance = this;

		this.prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				thisInstance.prevPage();
			}
		});

		this.nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				thisInstance.nextPage();
			}
		});
	}
}