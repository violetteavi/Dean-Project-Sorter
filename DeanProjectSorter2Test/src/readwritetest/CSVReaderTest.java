package readwritetest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import readwrite.CSVReader;

public class CSVReaderTest {

	@Test
	public void getsRecordsTest() {
		CSVReader test = new CSVReader();
		List<CSVRecord> records = null;
		try {
			records = test.parse(new File("C:\\Users\\family\\git\\Dean-Project-Sorter\\TestFile1.csv"));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		assertTrue("Babitch".equals(records.get(1).get(2)));
		assertTrue("".equals(records.get(2).get(5)));
		assertTrue("3rd Choice Topic".equals(records.get(0).get(8)));
	}
}
