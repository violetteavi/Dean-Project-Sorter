package readwrite;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReader {

	public List<CSVRecord> parse(File inputFile) throws IOException {
		CSVParser inputStream = null;
		List<CSVRecord> records = null;
		try {
			inputStream = CSVParser.parse(inputFile, Charset.defaultCharset(), CSVFormat.EXCEL);
            records = inputStream.getRecords();
		} finally {
			if(inputStream!=null) {
				inputStream.close();
			}
		}
		return records;
	}

}
