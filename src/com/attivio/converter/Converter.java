package com.attivio.converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Aastha
 *
 */

public class Converter {

	private String inputCSVFilePath;

	public Converter(String inputCSVFilePath) {
		this.inputCSVFilePath = inputCSVFilePath;
	}

	public void convertCSVToXML() {

		BufferedReader csvReader;
		String line;

		try {
			csvReader = new BufferedReader(new FileReader(this.inputCSVFilePath));

			// get column names from the very first line of the input CSV file,
			// otherwise file would be empty
			if ((line = csvReader.readLine()) != null) {
				String[] tokens = line.split(",");
				int undefinedColCount = 0;

				for (String token : tokens) {
					// if the first line doesn't contain a column name,
					// for example,
					// "col1,,col2,col3", then name the missing column name as
					// "undefined_ColumnName"
					if (token.equals("")) {
						XmlEntry.elementNames.add("undefined_ColumnName_" + ++undefinedColCount);
					} else {
						// ensure xml element names don't contain any spaces
						XmlEntry.elementNames.add(token.replaceAll(" ", ""));
					}
				}

				// if a line contains more values than the total number of
				// columns defined in the first line, then only that number of
				// values are considered as the total number of columns, the
				// remaining values are stored in the xmlEntry's values
				// ArrayList but are not used when printing the XML
				XmlEntry.maxElementCount = XmlEntry.elementNames.size();
			} else {
				System.out.print("Error: Empty File");
				csvReader.close();
				return;
			}

			System.out.print("<root>\n");

			while ((line = csvReader.readLine()) != null) {

				boolean allNullValues = true;
				String[] tokens = line.split(",");

				// if all values in the current row are null/blank then don't
				// create an xmlEntry for that record
				// for example,
				// ",,,"
				for (String token : tokens) {
					if (!token.equals("")) {
						allNullValues = false;
					}
				}

				if (!allNullValues) {
					XmlEntry entry = new XmlEntry();

					for (String token : tokens) {
						entry.getValues().add(token.trim());
					}

					System.out.print(entry.toString());
				}
			}

			System.out.print("</root>");

			csvReader.close();

		} catch (IOException e) {
			System.out.println("Exception: IOException\n" + e.getMessage());
		}

	}

}