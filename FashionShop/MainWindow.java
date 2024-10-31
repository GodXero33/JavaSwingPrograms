import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	private JPanel mainContainer;

	private CustomJButton placeOrderBtn;
	private CustomJButton searchCustomerBtn;
	private CustomJButton searchOrderBtn;
	private CustomJButton viewReportsBtn;
	private CustomJButton setOrderStatusBtn;
	private CustomJButton deleteOrderBtn;
	private CustomJButton exitBtn;

	MainWindow () {
		this.initWindow();
		this.buildLayout();
		this.addEvents();
		this.pack();
	}

	private void initWindow () {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle(CommonResources.title);
		this.setIconImage(CommonResources.icon);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private void buildLayout () {
		this.mainContainer = new JPanel(new GridLayout(3, 1, CommonResources.btnsGap, CommonResources.btnsGap));
		this.mainContainer.setBorder(CommonResources.padding1);
		this.mainContainer.setBackground(CommonResources.bgColor2);

		this.buildHeader();
		this.buildBtns();

		this.add(this.mainContainer);
	}

	private void buildHeader () {
		JLabel header = new JLabel("Fashion Shop");
		header.setBackground(CommonResources.bgColor4);
		header.setOpaque(true);
		header.setForeground(CommonResources.textColor1);
		header.setFont(CommonResources.font2);
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setIcon(CommonResources.cover);
		this.mainContainer.add(header);
	}

	private void buildBtns () {
		JPanel btnsPanel = new JPanel(new GridLayout(2, 3, CommonResources.btnsGap * 5, CommonResources.btnsGap * 5));
		btnsPanel.setBorder(CommonResources.padding2);
		btnsPanel.setBackground(CommonResources.bgColor2);

		this.placeOrderBtn = new CustomJButton("Place Order");
		btnsPanel.add(this.placeOrderBtn);

		this.searchCustomerBtn = new CustomJButton("Search Customer");
		btnsPanel.add(this.searchCustomerBtn);

		this.searchOrderBtn = new CustomJButton("Search Order");
		btnsPanel.add(this.searchOrderBtn);

		this.viewReportsBtn = new CustomJButton("View Reports");
		btnsPanel.add(this.viewReportsBtn);

		this.setOrderStatusBtn = new CustomJButton("Order Status");
		btnsPanel.add(this.setOrderStatusBtn);

		this.deleteOrderBtn = new CustomJButton("Delete Order");
		btnsPanel.add(this.deleteOrderBtn);

		this.mainContainer.add(btnsPanel);

		JPanel footerPanel = new JPanel();
		footerPanel.setBorder(CommonResources.padding1);
		footerPanel.setBackground(CommonResources.bgColor2);

		this.exitBtn = new CustomJButton("Exit");
		this.exitBtn.setBackground(CommonResources.bgColor3);
		footerPanel.add(this.exitBtn);

		this.mainContainer.add(footerPanel);
	}

	private void addEvents () {
		this.placeOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				if (CommonResources.isChildWindowOpened()) {
					CommonResources.secondChildWindowTryOpenAction();
					return;
				}

				CommonResources.setOpenedChildWindow(new PlaceOrderWindow());
			}
		});

		this.searchCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				if (CommonResources.isChildWindowOpened()) {
					CommonResources.secondChildWindowTryOpenAction();
					return;
				}

				CommonResources.setOpenedChildWindow(new SearchCustomerWindow());
			}
		});

		this.searchOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				if (CommonResources.isChildWindowOpened()) {
					CommonResources.secondChildWindowTryOpenAction();
					return;
				}


				CommonResources.setOpenedChildWindow(new SearchOrderWindow());
			}
		});

		this.viewReportsBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				if (CommonResources.isChildWindowOpened()) {
					CommonResources.secondChildWindowTryOpenAction();
					return;
				}

				CommonResources.setOpenedChildWindow(new ViewReportsWindow());
			}
		});

		this.setOrderStatusBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				if (CommonResources.isChildWindowOpened()) {
					CommonResources.secondChildWindowTryOpenAction();
					return;
				}

				CommonResources.setOpenedChildWindow(new SetOrderStatusWindow());
			}
		});

		this.deleteOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				if (CommonResources.isChildWindowOpened()) {
					CommonResources.secondChildWindowTryOpenAction();
					return;
				}

				CommonResources.setOpenedChildWindow(new DeleteOrderWindow());
			}
		});

		this.exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				int response = JOptionPane.showConfirmDialog(null, "Exit!");

				if (response == 0) {
					System.exit(0);
				}
			}
		});
	}
}
