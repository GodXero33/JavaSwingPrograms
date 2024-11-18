import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SearchOrderWindow extends ChildWindow {
	private CustomJButton searchBtn;
	private CustomTextField idValue;
	private CustomJLabel phoneValue;
	private CustomJLabel sizeValue;
	private CustomJLabel qtyValue;
	private CustomJLabel amountValue;
	private CustomJLabel statusValue;

	SearchOrderWindow () {
		this.setWindowName("Search Order");
		this.buildLayout();
		this.addCustomEvents();
		this.pack();
	}

	private void buildLayout () {
		JPanel labelsPanel = new JPanel(new GridLayout(6, 2, CommonResources.btnsGap, CommonResources.btnsGap));
		labelsPanel.setBorder(CommonResources.padding2);
		labelsPanel.setBackground(CommonResources.bgColor2);

		CustomJLabel idLbl = new CustomJLabel("ID");
		CustomJLabel phoneLbl = new CustomJLabel("Phone");
		CustomJLabel sizeLbl = new CustomJLabel("Size");
		CustomJLabel qtyLbl = new CustomJLabel("Quantity");
		CustomJLabel amountLbl = new CustomJLabel("Amount");
		CustomJLabel statusLbl = new CustomJLabel("Status");
		this.idValue = new CustomTextField();
		this.phoneValue = new CustomJLabel();
		this.sizeValue = new CustomJLabel();
		this.qtyValue = new CustomJLabel();
		this.amountValue = new CustomJLabel();
		this.statusValue = new CustomJLabel();
		
		labelsPanel.add(idLbl);
		labelsPanel.add(this.idValue);
		labelsPanel.add(phoneLbl);
		labelsPanel.add(this.phoneValue);
		labelsPanel.add(sizeLbl);
		labelsPanel.add(this.sizeValue);
		labelsPanel.add(qtyLbl);
		labelsPanel.add(this.qtyValue);
		labelsPanel.add(amountLbl);
		labelsPanel.add(this.amountValue);
		labelsPanel.add(statusLbl);
		labelsPanel.add(this.statusValue);

		JPanel searchBtnPanel = new JPanel();
		searchBtnPanel.setBorder(CommonResources.padding2);
		searchBtnPanel.setBackground(CommonResources.bgColor2);

		this.searchBtn = new CustomJButton("Search");
		searchBtnPanel.add(this.searchBtn);

		this.addComponent(labelsPanel);
		this.addComponent(searchBtnPanel);
	}

	private void updateWindow (OrderRecord recod) {
		this.phoneValue.setText(OrderRecord.getCustomer(recod));
		this.sizeValue.setText(OrderRecord.getSize(recod));
		this.qtyValue.setText(OrderRecord.getQTY(recod) + "");
		this.amountValue.setText(String.format("%.2f", OrderRecord.getAmount(recod)));
		this.statusValue.setText(OrderRecord.getStatus(recod));
	}

	private void reset () {
		this.idValue.setText("");
		this.phoneValue.setText("");
		this.sizeValue.setText("");
		this.qtyValue.setText("");
		this.amountValue.setText("");
		this.statusValue.setText("");
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

	private void addCustomEvents () {
		SearchOrderWindow thisInstance = this;

		this.searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				thisInstance.searchOrderID();
			}
		});
	}
}
