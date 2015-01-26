package readwrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import model.Person;
import model.TopicComponent;

public class CSVWriter {

	public void outputSolutions(TopicComponent tComponent, String outputPath) throws IOException {
		CSVPrinter outputStream = null;
		try {
			outputStream = new CSVPrinter(new BufferedWriter(new FileWriter(new File(outputPath))), CSVFormat.EXCEL);
			outputStream.print("Period");
			outputStream.print("First Name");
			outputStream.print("Last Name");
			outputStream.print("Assigned Topic");
			outputStream.print("Assigned Focus");
			outputStream.print("");
			outputStream.print("1st Choice Topic");
			outputStream.print("");
			outputStream.print("2nd Choice Topic");
			outputStream.print("");
			outputStream.print("3rd Choice Topic");
			outputStream.print("");
			outputStream.println();
			List<Person> persons = tComponent.getPersons();
			for(Person person: persons) {
				outputStream.print(person.getPeriod());
				outputStream.print(person.getFirstName());
				outputStream.print(person.getLastName());
				outputStream.print(person.getAssignment().getTopic().getName());
				if(person.getAssignment().getFocus()!=null) {
					outputStream.print(person.getAssignment().getFocus().getName());
				} else {
					outputStream.print("");
				}
				outputStream.print("");
				outputStream.print(person.getClaims().get(0).getTopic().getName());
				if(person.getClaims().get(0).getFocus()!=null) {
					outputStream.print(person.getClaims().get(0).getFocus().getName());
				} else {
					outputStream.print("");
				}
				outputStream.print(person.getClaims().get(1).getTopic().getName());
				if(person.getClaims().get(1).getFocus()!=null) {
					outputStream.print(person.getClaims().get(1).getFocus().getName());
				} else {
					outputStream.print("");
				}
				outputStream.print(person.getClaims().get(2).getTopic().getName());
				if(person.getClaims().get(2).getFocus()!=null) {
					outputStream.print(person.getClaims().get(2).getFocus().getName());
				} else {
					outputStream.print("");
				}
				outputStream.println();
			}
		} finally {
			if(outputStream!=null) {
				outputStream.close();
			}
		}
	}
}
