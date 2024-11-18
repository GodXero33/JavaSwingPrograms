import javax.swing.JButton;

public class CustomJButton extends JButton {
	CustomJButton (String text) {
		this.setFocusPainted(false);
		this.setBorderPainted(true);
		this.setText(text);
		this.setCursor(CommonResources.pointer);
		this.setBorder(CommonResources.btnsBorder);
		this.setFont(CommonResources.font1);
		this.setBackground(CommonResources.bgColor1);
		this.setForeground(CommonResources.textColor1);
	}

	public void disableBtn () {
		this.setEnabled(false);
	}

	public void enableBtn () {
		this.setEnabled(true);
	}
}
