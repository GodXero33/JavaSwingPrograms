import javax.swing.JLabel;

public class CustomJLabel extends JLabel {
	CustomJLabel (String text) {
		CustomJLabel.init(this, text);
	}

	CustomJLabel () {
		CustomJLabel.init(this, "");
	}

	private static void init (CustomJLabel label, String text) {
		label.setFont(CommonResources.font1);
		label.setOpaque(true);
		label.setText(text);
		label.setBorder(CommonResources.btnsBorder);
		label.setBackground(CommonResources.bgColor1);
		label.setForeground(CommonResources.textColor1);
		label.setHorizontalAlignment(JLabel.CENTER);
	}
}
