package readwrite;

import java.util.List;

import model.Focus;
import model.Person;
import model.Topic;
import model.TopicComponent;

import org.apache.commons.csv.CSVRecord;

public class CSVTranslator {

	@Deprecated
	public void generatePersons(List<CSVRecord> records, TopicComponent tComponent) {
		int firstNameIndex = -1;
		int lastNameIndex = -1;
		int periodIndex = -1;
		boolean isKey = true;
        for(CSVRecord record: records) {
        	if(isKey) {
        		for(int i = 0; i < record.size(); i++) {
        			if(record.get(i).equals("First Name")) {
        				firstNameIndex = i;
        			} else if(record.get(i).equals("Last Name")) {
        				lastNameIndex = i;
        			} else if(record.get(i).equals("Period")) {
        				periodIndex = i;
        			}
        		}
        		isKey = false;
        	} else {
        		new Person(record.get(firstNameIndex), record.get(lastNameIndex), 
        				intValue(record.get(periodIndex)), tComponent);
        	}
        }
	}

	private int intValue(String string) {
		return Integer.valueOf(string.substring(0, 1));
	}

	public void populateTopicComponent(List<CSVRecord> formRecords,	TopicComponent tComponent) {
		int firstTopicIndex = -1;
		int secondTopicIndex = -1;
		int thirdTopicIndex = -1;
		int firstNameIndex = -1;
		int lastNameIndex = -1;
		int periodIndex = -1;
		boolean isKey = true;
        for(CSVRecord record: formRecords) {
        	if(isKey) {
        		for(int i = 0; i < record.size(); i++) {
        			if(record.get(i).equals("First Name")) {
        				firstNameIndex = i;
        			} else if(record.get(i).equals("Last Name")) {
        				lastNameIndex = i;
        			} else if(record.get(i).equals("Period")) {
        				periodIndex = i;
        			} else if(record.get(i).equals("1st Choice Topic")) {
        				firstTopicIndex = i;
        			} else if(record.get(i).equals("2nd Choice Topic")) {
        				secondTopicIndex = i;
        			} else if(record.get(i).equals("3rd Choice Topic")) {
        				thirdTopicIndex = i;
        			}
        		}
        		isKey = false;
        	} else {
        		Person person = new Person(record.get(firstNameIndex), record.get(lastNameIndex), 
        				intValue(record.get(periodIndex)), tComponent);
        		Topic topic1 = new Topic(record.get(firstTopicIndex), tComponent);
        		Topic topic2 = new Topic(record.get(secondTopicIndex), tComponent);
        		Topic topic3 = new Topic(record.get(thirdTopicIndex), tComponent);
        		Focus focus1 = null;
        		if(!record.get(firstTopicIndex + 1).equals("")) {
        			focus1 = new Focus(record.get(firstTopicIndex + 1), topic1, tComponent);
        		}
        		Focus focus2 = null;
        		if(!record.get(secondTopicIndex + 1).equals("")) {
        			focus2 = new Focus(record.get(secondTopicIndex + 1), topic2, tComponent);
        		}
        		Focus focus3 = null;
        		if(thirdTopicIndex + 1 < record.size() && !record.get(thirdTopicIndex + 1).equals("")) {
        			focus3 = new Focus(record.get(thirdTopicIndex + 1), topic3, tComponent);
        		}
        		person.claim(topic1, focus1, 1);
        		person.claim(topic2, focus2, 2);
        		person.claim(topic3, focus3, 3);
        	}
        }
	}

}
