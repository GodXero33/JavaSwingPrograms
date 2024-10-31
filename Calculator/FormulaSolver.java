public class FormulaSolver {
	public static double solve (String formula) {
		String prevNum = null;
		char prevOpe = ' ';
		int beginIdx = 0;
		double ans = 0;

		if (formula.length() == 0 || isOperatorChar(formula.charAt(formula.length() - 1))) return 0.0;

		formula = formula.replaceAll(" ", "");

		for (int i = 0; i < formula.length(); i++) {
			char ch = formula.charAt(i);

			if (!isDigitChar(ch) && !isOperatorChar(ch)) return 0.0;

			if (isOperatorCharNoDot(ch)) {
				if (prevOpe == ' ') {
					prevNum = formula.substring(beginIdx, i);
					beginIdx = i + 1;
					prevOpe = ch;
				} else {
					String curNum = formula.substring(beginIdx, i);
					beginIdx = i + 1;
					double tmpAns = getAnswer(prevNum, curNum, prevOpe);
					prevOpe = ch;
					prevNum = tmpAns + "";
					ans = tmpAns;
				}
			}

			if (i == formula.length() - 1) {
				if (prevOpe == ' ') {
					return Double.parseDouble(formula);
				}

				String curNum = formula.substring(beginIdx);
				double tmpAns = getAnswer(prevNum, curNum, prevOpe);
				ans = tmpAns;
			}
		}
		
		return ans;
	}

	private static double getAnswer (String a, String b, char ope) {
		double num1 = Double.parseDouble(a);
		double num2 = Double.parseDouble(b);

		if (ope == '+') {
			return num1 + num2;
		} else if (ope == '-') {
			return num1 - num2;
		} else if (ope == '*') {
			return num1 * num2;
		} else if (ope == '/') {
			return num1 / num2;
		} else {
			return 0.0;
		}
	}
	
	private static boolean isOperatorCharNoDot (char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	public static boolean isDigitChar (char ch) {
		return ch >= 48 && ch <= 57;
	}

	public static boolean isOperatorChar (char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '.';
	}
}
