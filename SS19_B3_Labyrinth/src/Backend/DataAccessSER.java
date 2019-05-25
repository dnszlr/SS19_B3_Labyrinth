package Backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Interface.DataAccess;

public class DataAccessSER implements DataAccess, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void writeToFile(Object ser, String path) throws IOException {

		ObjectOutputStream oos = null;
		try {

			oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(ser);
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

	}

	@Override
	public Object readFile(String path) throws IOException, ClassNotFoundException {
		Object deSer = new Object();

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			deSer = ois.readObject();
		} catch (IOException e) {
			System.err.println("errors in the output");
		} catch (ClassNotFoundException e) {
			System.err.println("Class could not be found");
		}

		return deSer;
	}
}
