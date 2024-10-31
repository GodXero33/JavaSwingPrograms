import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CustomJTable {
	private JPanel tablePanel;
	private DefaultTableModel container;
	private JTable table;
	private OrderRecord[] records;

	CustomJTable () {
		this.tablePanel = new JPanel(new GridLayout(1, 2, CommonResources.btnsGap, CommonResources.btnsGap));
		this.tablePanel.setBorder(CommonResources.padding2);
		this.tablePanel.setBackground(CommonResources.bgColor2);
	}

	public JPanel getTablePanel () {
		return this.tablePanel;
	}

	public void setRecords (OrderRecord[] records) {
		this.records = records;
	}

	public void buildTable (String[] columns) {
		this.container = new DefaultTableModel(columns, 0);
		this.table = new JTable(this.container);
		this.table.setRowHeight(CommonResources.fontSize1 * 2);
		this.table.setFont(CommonResources.font1);
		this.table.setBackground(CommonResources.bgColor2);
		this.table.setForeground(CommonResources.textColor1);
		this.table.setRowMargin(CommonResources.fontSize1 / 4);
		this.table.setSelectionBackground(CommonResources.bgColor4);

		JTableHeader tableHeader = this.table.getTableHeader();
		tableHeader.setFont(CommonResources.font1);
		tableHeader.setBackground(CommonResources.bgColor1);
		tableHeader.setForeground(CommonResources.textColor1);

		JScrollPane scrollPane = new JScrollPane(this.table);
		tablePanel.add(scrollPane);

		this.calculateSearchTableHeight();
	}

	public void calculateSearchTableHeight () {
		int rowHeight = this.table.getRowHeight();
		int rowCount = this.table.getRowCount();
		int height = Math.min(rowHeight * rowCount, 200);

		this.table.setPreferredScrollableViewportSize(new Dimension(600, height));
	}

	public void updateRecords () {
		this.container.setRowCount(0);
		
		if (this.records == null || this.records.length == 0) return;

		for (OrderRecord record : this.records) {
			this.container.addRow(new Object[] {
				OrderRecord.getID(record),
				OrderRecord.getSize(record),
				OrderRecord.getQTY(record),
				OrderRecord.getAmount(record)
			});
		}

		this.calculateSearchTableHeight();
	}
}
