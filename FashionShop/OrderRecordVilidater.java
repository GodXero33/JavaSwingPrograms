public class OrderRecordVilidater {
	public static boolean isValidPhone (String phone) {
		return phone.matches("^0?7\\d{8}$");
	}

	public static boolean isValidSize (String size) {
		for (String checkSize : OrderRecord.SIZES) {
			if (size.toUpperCase().equals(checkSize)) return true;
		}

		return false;
	}

	public static boolean isValidQTY (String qty) {
		return qty.matches("^\\d+$") && Integer.parseInt(qty) != 0;
	}
}
