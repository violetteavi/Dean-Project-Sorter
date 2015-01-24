package model;

public class Assignment {

	private Person person;
	private Topic topic;
	private Focus focus;
	private TopicComponent component;
	
	private boolean predetermined;
	
	//getters and setters
	
	public Assignment(Person person, Topic topic, Focus focus, TopicComponent component, boolean predetermined) {
		this.person = person;
		person.setAssignment(this);
		this.topic = topic;
		topic.setAssignment(this);
		this.focus = focus;
		if(focus!=null) {
			focus.setAssignment(this);
		}
		person.deactivateClaims();
		this.predetermined = predetermined;
		
		this.component = component;
		component.addAssignment(this);
	}
	
	//getters and setters
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Focus getFocus() {
		return focus;
	}
	public void setFocus(Focus focus) {
		this.focus = focus;
	}	
	
}
