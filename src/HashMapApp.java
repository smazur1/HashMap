import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapApp {

	static File file = new File("map1.txt");

	public static void main(String[] args) throws FileNotFoundException {

		int number;
		String value;
		String more;
		String rdString;

		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		Scanner keyboard = new Scanner(System.in);

		try {
			Scanner scannerInput = new Scanner(file);
			while (scannerInput.hasNextLine()) {
				rdString = scannerInput.nextLine();

				String[] parts = rdString.split(",");
				number = Integer.parseInt(parts[0]);
				value = parts[1];

				myMap.put(number, value);

			}
			scannerInput.close();
		} catch (IOException e) {
			e.getMessage().toString();
		}
		boolean moreEntries = true;
		while (moreEntries == true) {

			System.out.println("Enter a number : ");
			number = Integer.parseInt(keyboard.next());

			if (!myMap.containsKey(number)) {
				System.out.println("Enter the value for the number :");
				value = keyboard.next();
				myMap.put(number, value);

			} else {
				value = myMap.get(number);
				System.out.println("You entered " + value);

			}
			System.out.println("Do you want to enter another number? (y) or (n)");
			more = keyboard.next();
			if (!more.equalsIgnoreCase("y")) {
				moreEntries = false;
			}
		} // end while

		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);

			for (int i : myMap.keySet()) {
				writer.write(i + "," + myMap.get(i) + "\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.getMessage().toString();
		}
	}

}
