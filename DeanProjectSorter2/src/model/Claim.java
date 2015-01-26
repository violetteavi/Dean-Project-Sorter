package model;

public class Claim implements Comparable<Claim> {

	private Person person;
	private Topic topic;
	private Focus focus;
	private TopicComponent component;
	
	private boolean isActive;
	private int priority;

	
	public Claim(Person person, Topic topic, Focus focus, int priority, TopicComponent component) {
		this.person = person;
		person.addClaim(this);
		this.topic = topic;
		topic.addClaim(this);
		this.focus = focus;
		if(focus!=null) {
			focus.setClaim(this);
		}
		topic.addFocus(focus);
		this.setComponent(component);
		component.addClaim(this);
		
		isActive = true;
		this.setPriority(priority);	
	}

	public void deactivate() {
		isActive = false;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public TopicComponent getComponent() {
		return component;
	}

	public void setComponent(TopicComponent component) {
		this.component = component;
	}

	@Override
	public int compareTo(Claim that) {
		if(this.getPriority()<that.getPriority()) {
			return -1;
		} else if (this.getPriority()==that.getPriority()) {
			return 0;
		} else if(that.getPriority() < this.getPriority()){
			return 1;
		} else {
			return 0;
		}
	}	
}
