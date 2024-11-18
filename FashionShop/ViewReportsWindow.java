import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ViewReportsWindow extends ChildWindow {
	private CustomJButton viewCustomersBtn;
	private CustomJButton bestInCustomersBtn;
	private CustomJButton allCustomersBtn;
	private CustomJButton catByQtyBtn;
	private CustomJButton catByAmountBtn;
	private CustomJButton ordersByAmountBtn;
	private CustomJButton allOrdersBtn;

	ViewReportsWindow () {
		this.setWindowName("View Reports");
		this.buildLayout();
		this.addCustomEvents();
		this.pack();
	}

	private void buildLayout () {
		JPanel labelsPanel = new JPanel();
		labelsPanel.setBorder(CommonResources.padding2);
		labelsPanel.setBackground(CommonResources.bgColor2);

		JPanel labelsHolderPanel1 = new JPanel(new GridLayout(3, 1, CommonResources.btnsGap, CommonResources.btnsGap));
		JPanel labelsHolderPanel2 = new JPanel(new GridLayout(2, 1, CommonResources.btnsGap, CommonResources.btnsGap));
		JPanel labelsHolderPanel3 = new JPanel(new GridLayout(2, 1, CommonResources.btnsGap, CommonResources.btnsGap));

		labelsHolderPanel1.setBorder(CommonResources.padding2);
		labelsHolderPanel1.setBackground(CommonResources.bgColor2);
		labelsHolderPanel2.setBorder(CommonResources.padding2);
		labelsHolderPanel2.setBackground(CommonResources.bgColor2);
		labelsHolderPanel3.setBorder(CommonResources.padding2);
		labelsHolderPanel3.setBackground(CommonResources.bgColor2);

		this.viewCustomersBtn = new CustomJButton("View Customers");
		this.bestInCustomersBtn = new CustomJButton("Best In Customers");
		this.allCustomersBtn = new CustomJButton("All Customers");
		this.catByQtyBtn = new CustomJButton("Categorized by QTY");
		this.catByAmountBtn = new CustomJButton("Categorized by Amount");
		this.ordersByAmountBtn = new CustomJButton("Orders by Amount");
		this.allOrdersBtn = new CustomJButton("All Orders");

		labelsHolderPanel1.add(viewCustomersBtn);
		labelsHolderPanel1.add(bestInCustomersBtn);
		labelsHolderPanel1.add(allCustomersBtn);

		labelsHolderPanel2.add(catByQtyBtn);
		labelsHolderPanel2.add(catByAmountBtn);

		labelsHolderPanel3.add(ordersByAmountBtn);
		labelsHolderPanel3.add(allOrdersBtn);

		labelsPanel.add("East", labelsHolderPanel1);
		labelsPanel.add("Center", labelsHolderPanel2);
		labelsPanel.add("West", labelsHolderPanel3);

		this.addComponent(labelsPanel);
	}

	private void addCustomEvents () {
		this.viewCustomersBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				CommonResources.forceToCloseCurrentWindow();
				CommonResources.setOpenedChildWindow(new ViewCustomersWindow());
			}
		});

		this.bestInCustomersBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				CommonResources.forceToCloseCurrentWindow();
				CommonResources.setOpenedChildWindow(new BestInCustomersWindow());
			}
		});

		this.allCustomersBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				CommonResources.forceToCloseCurrentWindow();
				CommonResources.setOpenedChildWindow(new AllCustomersWindow());
			}
		});

		this.catByQtyBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				CommonResources.forceToCloseCurrentWindow();
				CommonResources.setOpenedChildWindow(new CatByQTYWindow());
			}
		});


		this.catByAmountBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				CommonResources.forceToCloseCurrentWindow();
				CommonResources.setOpenedChildWindow(new CatByAmountWindow());
			}
		});

		this.ordersByAmountBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				CommonResources.forceToCloseCurrentWindow();
				CommonResources.setOpenedChildWindow(new OrdersByAmountWindow());
			}
		});

		this.allOrdersBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				CommonResources.forceToCloseCurrentWindow();
				CommonResources.setOpenedChildWindow(new AllOrdersWindow());
			}
		});
	}
}
