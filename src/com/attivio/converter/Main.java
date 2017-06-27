package com.attivio.converter;

/**
 * @author Aastha
 *
 */

public class Main {

	public static void main(String[] args) {

		String inputCSVFilePath = "src/CSVFiles/input.csv";

		new Converter(inputCSVFilePath).convertCSVToXML();
	}
}
