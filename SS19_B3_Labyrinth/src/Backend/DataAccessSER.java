package Backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataAccessSER implements DataAccess {

	@Override
	public void writeToFile(String path, String type) throws IOException {
		switch (type) {
		case "Serialization":
			ObjectOutputStream oos = null;
			try {
				Manager manager = new Manager();
				oos = new ObjectOutputStream(new FileOutputStream(path));
				oos.writeObject(manager);
				System.out.println(manager);
			} catch (FileNotFoundException e) {
				System.err.println(path + " could not be created");
			} catch (IOException e) {
				System.err.println("errors in the input");
				System.out.println(e.getClass());
				System.out.println(e.getMessage());
			} finally {
				try {
					oos.close();
				} catch (Exception e) {
					System.err.println("Error closing a file");
				}

			}
			break;

		default:
			System.err.println("Wrong type, Serialization works");
			break;
		}

	}

	@Override
	public void readFile(String path, String type) throws IOException, ClassNotFoundException {

		switch (type) {
		case "Serialization":
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream(path));
				Manager m = (Manager) ois.readObject();
				System.out.println(m);
			} catch (IOException e) {
				System.err.println("errors in the output");
			} catch (ClassNotFoundException e) {
				System.err.println("Class could not be found");
			}

			break;

		default:
			System.err.println("Wrong type, Serialization works");
			break;
		}

	}

}
