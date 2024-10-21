package handlingCSV_Files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class CreateCSV_File {

	public void createCSVFile(String path, List<String> headers, List<List> data) throws IOException {

		int size = headers.size();
		int index = 0;
		FileWriter writer = new FileWriter(path);
		String header = "";

		for (int a = 0; a < size; a++) {
			header = header + headers.get(a) + ",";
		}
		if (header.endsWith(",")) {
			header = header.substring(0, header.length() - 1);
		}
		header = header + " \n";

		writer.append(header);
		List<String> finishedData = new ArrayList<>();

		for (int b = 0; b < data.size(); b++) {
			String value = "";
			List<String> values = data.get(b);
			for (int c = 0; c < values.size(); c++) {
				value = value + values.get(c) + ",";
			}
			if (value.endsWith(",")) {
				value = value.substring(0, value.length() - 1);
			}
			finishedData.add(value + " \n");
		}
		for (int d = 0; d < finishedData.size(); d++) {
			writer.append(finishedData.get(d));
		}

		writer.close();
	}

//@Test
	public void estam() throws IOException {

		String path = "C:\\Users\\besi\\OneDrive\\Desktop\\projects\\PaypalApi\\binaryFiles\\csv1";

		List<String> headers = Arrays.asList("name", "age", "emailbre");
		List<String> data1 = Arrays.asList("mile", "31", "zika@gmail.com");
		List<String> data2 = Arrays.asList("kemo", "25", "kemo@gmail.com");
		List<String> data3 = Arrays.asList("eki", "35", "eki@gmail.com");
		List<List> data = Arrays.asList(data1, data2, data3);

		createCSVFile(path, headers, data);

	}

//@Test
	public void estamads() {

		String jasi = "jamakasi motageri honda";

		jasi = jasi.substring(0, jasi.length() - 1);
		System.out.println(jasi);

	}

}
