import javax.swing.JTextField;

public class CustomTextField extends JTextField {
	CustomTextField () {
		this.setFont(CommonResources.font1);
		this.setOpaque(true);
		this.setBorder(CommonResources.btnsBorder);
		this.setBackground(CommonResources.bgColor6);
		this.setForeground(CommonResources.textColor2);
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setFont(CommonResources.font1);
	}
}
