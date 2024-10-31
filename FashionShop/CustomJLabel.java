import javax.swing.JLabel;

public class CustomJLabel extends JLabel {
	CustomJLabel (String text) {
		this.setFont(CommonResources.font1);
		this.setOpaque(true);
		this.setText(text);
		this.setBorder(CommonResources.btnsBorder);
		this.setBackground(CommonResources.bgColor1);
		this.setForeground(CommonResources.textColor1);
		this.setHorizontalAlignment(JLabel.CENTER);
	}
}
