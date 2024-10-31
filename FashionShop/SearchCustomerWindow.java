import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SearchCustomerWindow extends ChildWindow {
	private CustomJButton searchBtn;
	private CustomTextField phoneValue;
	private CustomJTable tableObject;

	SearchCustomerWindow () {
		this.setWindowName("Search Customer");
		this.buildLayout();
		this.addCustomEvents();
		this.pack();
	}

	private void buildLayout () {
		JPanel phonePanel = new JPanel(new GridLayout(1, 2, CommonResources.btnsGap, CommonResources.btnsGap));
		phonePanel.setBorder(CommonResources.padding2);
		phonePanel.setBackground(CommonResources.bgColor2);

		CustomJLabel phoneLbl = new CustomJLabel("Phone");
		this.phoneValue = new CustomTextField();
		phonePanel.add(phoneLbl);
		phonePanel.add(this.phoneValue);

		this.tableObject = new CustomJTable();
		this.tableObject.buildTable(new String[] { "Order ID", "Size", "Quantity", "Amount" });

		JPanel searchBtnPanel = new JPanel();
		searchBtnPanel.setBorder(CommonResources.padding2);
		searchBtnPanel.setBackground(CommonResources.bgColor2);

		this.searchBtn = new CustomJButton("Search");
		searchBtnPanel.add(this.searchBtn);

		this.addComponent(phonePanel);
		this.addComponent(this.tableObject.getTablePanel());
		this.addComponent(searchBtnPanel);
	}

	private boolean searchCustomerOrders () {
		String customer = this.phoneValue.getText();

		if (customer == null || !OrderRecordVilidater.isValidPhone(customer)) return false;
		if (customer.length() == 9) customer = '0' + customer;
	
		this.tableObject.setRecords(CommonResources.orderManager.search(customer));
		this.tableObject.updateRecords();
		this.pack();

		return true;
	}

	private void addCustomEvents () {
		SearchCustomerWindow thisInstance = this;

		this.searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				// If 'searchCustomerOrders()' returns false, that means the phone number in the text field is invalid.
				if (!thisInstance.searchCustomerOrders()) {
					JOptionPane.showMessageDialog(null, "Invalid Phone number!");
				}
			}
		});
	}
}
