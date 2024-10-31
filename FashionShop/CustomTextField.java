import javax.swing.JTextField;

public class CustomTextField extends JTextField {
	CustomTextField () {
		this.setFont(CommonResources.font1);
		this.setOpaque(true);
		this.setBorder(CommonResources.btnsBorder);
		this.setBackground(CommonResources.bgColor1);
		this.setForeground(CommonResources.textColor1);
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setFont(CommonResources.font1);
	}
}
