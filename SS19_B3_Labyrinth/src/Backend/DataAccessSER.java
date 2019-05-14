package Backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataAccessSER implements DataAccess, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void writeToFile(Object ser, String path, String type) throws IOException {
		switch (type) {
		case "Serialization":
			ObjectOutputStream oos = null;
			try {

				oos = new ObjectOutputStream(new FileOutputStream(path));
				oos.writeObject(ser);
				System.out.println(ser);
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
	public Object readFile(String path, String type) throws IOException, ClassNotFoundException {
		Manager deSer = new Manager();
		switch (type) {
		case "Serialization":
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream(path));
				deSer = (Manager) ois.readObject();
				System.out.println(deSer);
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
		return deSer;

	}
}
