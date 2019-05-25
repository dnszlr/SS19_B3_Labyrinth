package Backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Interface.DataAccess;

public class DataAccessCSV implements DataAccess {

	@Override
	public void writeToFile(Object csv, String path) throws IOException {
		PrintWriter pw = null;

		try {
			Manager csvLoad = (Manager) csv;
			csvLoad.writeToStream(new PrintWriter(System.out));
			pw = new PrintWriter(new FileWriter(path));
			csvLoad.writeToStream(pw);

		} finally {
			if (pw != null) {
				pw.close();
			}

		}

	}

	@Override
	public Object readFile(String path) throws IOException, ClassNotFoundException {
		BufferedReader reader = null;
		Manager csvWrite;
		try {
			reader = new BufferedReader(new FileReader(path));
			csvWrite = new Manager(reader);
			System.out.println(csvWrite);
		} finally {
			reader.close();

		}
		return csvWrite;
	}

}
