package handlingCSV_Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class ReadCSV_File {

//*** USING SCANNER CLASS ***

	public List<String> read_csv_file(String path) throws FileNotFoundException {

		List<String> list = new ArrayList<>();
		File file = new File(path);
		Scanner sc = new Scanner(file);

		while (sc.hasNext()) {
			list.add(sc.next() + "\t");
		}
		return list;
	}

	@Test(description = "getting with scanner class and store as values")
	public void estam() throws FileNotFoundException {

		String path = "C:\\Users\\pupa\\OneDrive\\Desktop\\projects\\PaypalApi\\binaryFiles\\csv1";
		List<String> list = read_csv_file(path);
		List<String> names = new ArrayList<>();
		List<String> ages = new ArrayList<>();
		List<String> mails = new ArrayList<>();
		for (String item : list) {
			String[] items = item.split(",");
			names.add(items[0]);
			ages.add(items[1]);
			mails.add(items[2]);
		}
		System.out.println(ages);
	}

//*** USING BUFFER READER CLASS ***

	public List<List<String>> read_csv_file_02(String path) throws IOException {

		List<List<String>> datas = new ArrayList<>();
		FileReader reader = new FileReader(path);
		BufferedReader bfreader = new BufferedReader(reader);
		String line;

		while ((line = bfreader.readLine()) != null) {
			String[] data = line.split(",");
			List<String> data0 = Arrays.stream(data).collect(Collectors.toList());
			datas.add(data0);
		}
		return datas;
	}

	@Test(description="getting with help of buffered reader class")
	public void estam01() throws IOException {

		String path = "C:\\Users\\pap\\OneDrive\\Desktop\\projects\\PaypalApi\\binaryFiles\\csv1";
		List<List<String>> list = read_csv_file_02(path);

		System.out.println(list);
	}

}
