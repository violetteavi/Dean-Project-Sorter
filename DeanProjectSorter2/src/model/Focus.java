package model;

public class Focus {

	private Claim claim;
	private Topic topic;
	private Assignment assignment;
	private TopicComponent component;
	private String name;
	
	public Focus(String focusName, Topic topic, TopicComponent component) {
		name = focusName;
		this.topic = topic;
		component.addFocus(this);
	}
	
	//getters and setters
	
	public Claim getClaim() {
		return claim;
	}
	public void setClaim(Claim claim) {
		this.claim = claim;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	public String getName() {
		return name;
	}
}
