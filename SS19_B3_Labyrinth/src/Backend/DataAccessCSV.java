package Backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Backend.Map.Gameboard;
import Interface.DataAccess;

public class DataAccessCSV implements DataAccess {

	@Override
	public void writeToFile(Object csv, String path) throws IOException {
		PrintWriter pw = null;

		try {
			Gameboard csvWrite = (Gameboard) csv;
			pw = new PrintWriter(new FileWriter(path));
			csvWrite.writeToStream(pw);

		} finally {
			if (pw != null) {
				pw.close();
			}

		}

	}

	@Override
	public Object readFile(String path) throws IOException, FileNotFoundException {
		BufferedReader reader = null;
		Object csvLoad;
		try {
			reader = new BufferedReader(new FileReader(path));
			csvLoad = new Gameboard(reader);
		} finally {
			reader.close();

		}
		return csvLoad;
	}

}
