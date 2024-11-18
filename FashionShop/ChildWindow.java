import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChildWindow extends JFrame {
	private String windowName;
	private JPanel mainContainer;
	private JPanel header;
	private JPanel footer;
	private JPanel body;
	private JLabel title;
	private CustomJButton backBtn;

	ChildWindow () {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setIconImage(CommonResources.icon);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.buildMainContainer();
		this.buildHeader();
		this.buildBody();
		this.buildFooter();
		this.add(this.mainContainer);

		this.addBackBtnEvent();
		this.addWindowCloseEvent();
	}

	public void setWindowName (String name) {
		this.windowName = name;
		this.setTitle(CommonResources.title + " - " + name);
		this.title.setText(this.windowName);
	}

	public String getWindowName () {
		return this.windowName;
	}

	public void addComponent (Component component) {
		this.body.add(component);
	}

	public void buildMainContainer () {
		this.mainContainer = new JPanel(new BorderLayout());
		this.mainContainer.setBorder(CommonResources.padding1);
		this.mainContainer.setBackground(CommonResources.bgColor2);
	}

	public void buildHeader () {
		this.header = new JPanel();
		this.header.setBackground(CommonResources.bgColor4);
		this.header.setBorder(CommonResources.padding3);

		this.title = new JLabel();
		this.title.setForeground(CommonResources.textColor1);
		this.title.setFont(CommonResources.font2);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setIcon(CommonResources.cover);

		this.header.add(title);
		this.mainContainer.add(this.header, BorderLayout.NORTH);
	}

	public void buildBody () {
		this.body = new JPanel();
		this.body.setLayout(new BoxLayout(this.body, BoxLayout.Y_AXIS));
		this.body.setBorder(CommonResources.padding1);
		this.body.setBackground(CommonResources.bgColor2);

		this.mainContainer.add(this.body, BorderLayout.CENTER);
	}

	public void buildFooter () {
		this.footer = new JPanel();
		this.footer.setBorder(CommonResources.padding1);
		this.footer.setBackground(CommonResources.bgColor2);

		this.backBtn = new CustomJButton("Back");
		this.backBtn.setBackground(CommonResources.bgColor3);

		this.footer.add(this.backBtn);
		this.mainContainer.add(this.footer, BorderLayout.SOUTH);
	}

	public void windowClose () {
		CommonResources.closeChildWindow();
		this.dispose();
	}

	public void addBackBtnEvent () {
		ChildWindow thisInstance = this;

		this.backBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				thisInstance.windowClose();
			}
		});
	}

	private void addWindowCloseEvent () {
		ChildWindow thisInstance = this;

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent event) {
				thisInstance.windowClose();
			}
		});
	}
}
