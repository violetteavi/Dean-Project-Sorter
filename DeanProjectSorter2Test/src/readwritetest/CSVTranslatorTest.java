package readwritetest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import model.TopicComponent;

import org.apache.commons.csv.CSVRecord;
import org.junit.Before;
import org.junit.Test;

import readwrite.CSVReader;
import readwrite.CSVTranslator;

public class CSVTranslatorTest {
	
	CSVReader reader;
	List<CSVRecord> formRecords;
	List<CSVRecord> topicRecords;
	TopicComponent tComponent;
	CSVTranslator test;
	
	@Before
	public void init() {
		reader = new CSVReader();
		formRecords = null;
		try {
			formRecords = reader.parse(new File("C:\\Users\\family\\git\\Dean-Project-Sorter\\TestFile1.csv"));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		tComponent = new TopicComponent();
		test = new CSVTranslator();
	}

	@Test
	public void addsPersonsTest() {
		test.generatePersons(formRecords, tComponent);
		assertTrue("Babitch".equals(tComponent.getPersons().get(0).getLastName()));
		assertEquals(2, tComponent.getPersons().get(1).getPeriod());
		assertTrue("Ethan".equals(tComponent.getPersons().get(2).getFirstName()));
	}

	@Test
	public void addsClaimsTest() {
		test.populateTopicComponent(formRecords, tComponent);
		assertTrue("Manhattan Project".equals(tComponent.getPersons().get(0).getClaims().get(2).getTopic().getName()));
		assertTrue("Three Mile Island".equals(tComponent.getPersons().get(1).getClaims().get(1).getTopic().getName()));
		assertTrue("Chaplin, Charlie".equals(tComponent.getPersons().get(2).getClaims().get(0).getTopic().getName()));
		assertTrue("Dancing".equals(tComponent.getPersons().get(2).getClaims().get(0).getFocus().getName()));
	}

}
