package com.attivio.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aastha
 *
 */

public class XmlEntry {

	public static List<String> elementNames = new ArrayList<>();
	public static int maxElementCount;
	private int elementCount;
	private List<String> values;

	public XmlEntry() {
		this.elementCount = elementNames.size();
		this.values = new ArrayList<>();
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		elementCount = 0;

		sb.append("\t<record>\n");

		for (String value : this.values) {
			if (elementCount < maxElementCount) {
				// in case of a blank value, move to the next column/element
				// value and skip the current one
				if (!value.equals("")) {
					sb.append("\t\t<").append(elementNames.get(elementCount)).append(">");
					sb.append(value);
					sb.append("</").append(elementNames.get(elementCount)).append(">").append("\n");
				}
				elementCount++;
			}
		}

		sb.append("\t</record>\n");

		return sb.toString();
	}
}