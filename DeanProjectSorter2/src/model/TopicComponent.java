package model;

import java.util.LinkedList;
import java.util.List;

public class TopicComponent {

	List<Person> persons;
	List<Topic> topics;
	List<Claim> claims;
	List<Focus> focuses;
	List<Assignment> assignments;
	
	public TopicComponent() {
		persons = new LinkedList<Person>();
		topics = new LinkedList<Topic>();
		claims = new LinkedList<Claim>();
		focuses = new LinkedList<Focus>();
		assignments = new LinkedList<Assignment>();
	}

	public void addFocus(Focus focus) {
		focuses.add(focus);
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void addClaim(Claim claim) {
		claims.add(claim);
	}

	public void addAssignment(Assignment assignment) {
		assignments.add(assignment);
	}

	public void addPerson(Person person) {
		persons.add(person);
	}

	public List<Person> getPersons() {
		return persons;
	}
}
