import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeleteOrderWindow extends ChildWindow {
	private CustomJButton searchBtn;
	private CustomJButton deleteBtn;

	private CustomTextField idValue;
	private CustomJLabel phoneValue;
	private CustomJLabel sizeValue;
	private CustomJLabel qtyValue;
	private CustomJLabel amountValue;
	private CustomJLabel statusValue;

	private OrderRecord currentOrder;

	DeleteOrderWindow () {
		this.setWindowName("Delete Order");
		this.buildLayout();
		this.addCustomEvents();
		this.pack();
	}

	private void buildLayout () {
		JPanel bodyPanel = new JPanel(new GridLayout(6, 2, CommonResources.btnsGap, CommonResources.btnsGap));
		bodyPanel.setBorder(CommonResources.padding2);
		bodyPanel.setBackground(CommonResources.bgColor2);

		// Labels
		CustomJLabel idLbl = new CustomJLabel("ID");
		CustomJLabel phoneLbl = new CustomJLabel("Phone");
		CustomJLabel sizeLbl = new CustomJLabel("Size");
		CustomJLabel qtyLbl = new CustomJLabel("Qty");
		CustomJLabel amountLbl = new CustomJLabel("Amount");
		CustomJLabel statusLbl = new CustomJLabel("Status");
		this.idValue = new CustomTextField();
		this.amountValue = new CustomJLabel();
		this.phoneValue = new CustomJLabel();
		this.sizeValue = new CustomJLabel();
		this.qtyValue = new CustomJLabel();
		this.statusValue = new CustomJLabel();

		bodyPanel.add(idLbl);
		bodyPanel.add(this.idValue);
		bodyPanel.add(phoneLbl);
		bodyPanel.add(this.phoneValue);
		bodyPanel.add(sizeLbl);
		bodyPanel.add(this.sizeValue);
		bodyPanel.add(qtyLbl);
		bodyPanel.add(this.qtyValue);
		bodyPanel.add(amountLbl);
		bodyPanel.add(this.amountValue);
		bodyPanel.add(statusLbl);
		bodyPanel.add(this.statusValue);

		JPanel btnsPanel = new JPanel();
		btnsPanel.setBorder(CommonResources.padding2);
		btnsPanel.setBackground(CommonResources.bgColor2);

		this.searchBtn = new CustomJButton("Search");
		this.deleteBtn = new CustomJButton("Delete Order");
		this.deleteBtn.disableBtn();
		
		btnsPanel.add(this.searchBtn);
		btnsPanel.add(this.deleteBtn);

		this.addComponent(bodyPanel);
		this.addComponent(btnsPanel);
	}

	private void updateWindow (OrderRecord record) {
		this.phoneValue.setText(OrderRecord.getCustomer(record));
		this.sizeValue.setText(OrderRecord.getSize(record));
		this.qtyValue.setText(OrderRecord.getQTY(record) + "");
		this.amountValue.setText(String.format("%.2f", OrderRecord.getAmount(record)));
		this.statusValue.setText(OrderRecord.getStatus(record));

		this.currentOrder = record;
		this.deleteBtn.enableBtn();
	}

	private void reset () {
		this.idValue.setText("");
		this.phoneValue.setText("");
		this.sizeValue.setText("");
		this.qtyValue.setText("");
		this.amountValue.setText("");
		this.statusValue.setText("");

		this.currentOrder = null;
		this.deleteBtn.disableBtn();
	}

	private void searchOrderID () {
		String id = this.idValue.getText();

		if (id == null || !id.matches("^\\d+$")) {
			JOptionPane.showMessageDialog(null, "Invalid ID!");
			this.reset();
			return;
		}

		OrderRecord searchedRecord = CommonResources.orderManager.search(Integer.parseInt(id));

		if (searchedRecord == null) {
			JOptionPane.showMessageDialog(null, "Order is not found!");
			this.reset();
			return;
		}

		this.updateWindow(searchedRecord);
	}

	private void saveData () {
		boolean isFileSaved = CommonResources.orderManager.save();

		if (isFileSaved) {
			JOptionPane.showMessageDialog(null, "Order Daleted!");
			this.reset();
		} else {
			JOptionPane.showMessageDialog(null, "Failed to delete the order! File not saved!");
		}
	}

	private void deleteRecord () {
		int response = JOptionPane.showOptionDialog(
			null,
			"Do you want to delete this order?",
			"Delete confirmation",
			JOptionPane.DEFAULT_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			new String[] { "Yes", "No" },
			"No"
		);

		if (response == 0) {
			response = CommonResources.orderManager.remove(this.currentOrder);
			
			if (response == OrderManager.REMOVE_RECORD_FAILED) {
				JOptionPane.showMessageDialog(null, "Failed to Delete!");
			} else {
				saveData();
			}
		}
	}

	private void addCustomEvents () {
		DeleteOrderWindow thisInstance = this;

		this.searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				thisInstance.searchOrderID();
			}
		});

		this.deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				thisInstance.deleteRecord();
			}
		});
	}
}
