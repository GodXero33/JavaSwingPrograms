import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CustomJTable {
	private JPanel tablePanel;
	private DefaultTableModel container;
	private JTable table;
	private int defaultTableWidth = 600;
	private int defaultTableHeight = 0;

	CustomJTable () {
		this.tablePanel = new JPanel(new GridLayout(1, 2, CommonResources.btnsGap, CommonResources.btnsGap));
		this.tablePanel.setBorder(CommonResources.padding2);
		this.tablePanel.setBackground(CommonResources.bgColor2);
	}

	public JPanel getTablePanel () {
		return this.tablePanel;
	}

	public void setRowCount (int count) {
		this.container.setRowCount(count);
	}

	public void addRow (Object[] obj) {
		this.container.addRow(obj);
	}

	public void setWidth (int width) {
		this.defaultTableWidth = width;
	}

	public void setHeight (int height) {
		this.defaultTableHeight = height;
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

		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < this.table.getColumnCount(); i++) {
			this.table.getColumnModel().getColumn(i).setCellRenderer(centerCellRenderer);
		}

		JTableHeader tableHeader = this.table.getTableHeader();
		tableHeader.setFont(CommonResources.font1);
		tableHeader.setBackground(CommonResources.bgColor1);
		tableHeader.setForeground(CommonResources.textColor1);

		JScrollPane scrollPane = new JScrollPane(this.table);
		tablePanel.add(scrollPane);

		this.calculateSearchTableHeight();
	}

	public void calculateSearchTableHeight () {
		int min = 200;

		if (this.defaultTableHeight != 0) {
			min = this.defaultTableHeight;
		}

		int rowHeight = this.table.getRowHeight();
		int rowCount = this.table.getRowCount();
		int height = Math.min(rowHeight * rowCount, min);

		this.table.setPreferredScrollableViewportSize(new Dimension(this.defaultTableWidth, height));
	}
}
