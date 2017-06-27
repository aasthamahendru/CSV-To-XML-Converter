package com.attivio.converter;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Aastha
 *
 */

public class Tests {

	private final ByteArrayOutputStream printOut = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		System.setOut(new PrintStream(printOut));
	}

	@After
	public void clearConsole() {
		System.setOut(null);
	}

	@Test
	public void emptyRecordTest() {
		String expectedOutput = "<root>\n</root>";

		new Converter("src/CSVFiles/emptyRecordTestInput_1.csv").convertCSVToXML();

		assertEquals(expectedOutput, printOut.toString());
	}

	@Test
	public void undefinedColumnTest() {
		StringBuilder sb = new StringBuilder();

		sb.append("<root>\n");
		sb.append("\t<record>\n");
		sb.append("\t\t<CustomerID>1</CustomerID>\n").append("\t\t<Name>Ana</Name>\n");
		sb.append("\t\t<undefined_ColumnName_1>Boston</undefined_ColumnName_1>\n");
		sb.append("\t\t<Amount>6.88</Amount>\n").append("\t\t<ZipCode>02215</ZipCode>\n");
		sb.append("\t</record>\n");
		sb.append("</root>");

		new Converter("src/CSVFiles/undefinedColumnTestInput_2.csv").convertCSVToXML();

		assertEquals(sb.toString(), printOut.toString());
	}

	@Test
	public void emptyFileTest() {
		String error = "Error: Empty File";

		new Converter("src/CSVFiles/emptyFileTestInput_3.csv").convertCSVToXML();

		assertEquals(error.toString(), printOut.toString());
	}
}
