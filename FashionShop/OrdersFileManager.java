import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrdersFileManager {
	private String path = "data/orders.txt";

	public boolean save (String text) {
		try {
			FileWriter writer = new FileWriter(this.path);
			writer.write(text);
			writer.flush();
			writer.close();
			return true;
		} catch (IOException exception) {
			System.out.println(exception);
		}

		return false;
	}

	public String[] read () {
		try {
			Scanner reader = new Scanner(new File(this.path));
			String[] data = new String[0];

			while (reader.hasNext()) {
				int len = data.length;
				String[] copy = new String[len + 1];

				for (int i = 0; i < len; i++) {
					copy[i] = data[i];
				}

				copy[len] = reader.nextLine();
				data = copy;
			}

			reader.close();
			return data;
		} catch (IOException exception) {
			System.out.println(exception);
		}

		return null;
	}
}
