package model;

import java.util.LinkedList;
import java.util.List;

public class Person {
	
	private List<Claim> claims;
	private Assignment assignment;
	private TopicComponent component;
	
	private String firstName;
	private String lastName;
	private int period;

	public Person(String firstName, String lastName, int period, TopicComponent component) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.period = period;
		claims = new LinkedList<Claim>();
		this.component = component;
		component.addPerson(this);
	}
	
	public void claim(Topic topic, Focus focus, int priority) {
		new Claim(this, topic, focus, priority, component);
	}
	
	public void assign(Claim claim) {
		new Assignment(this, claim.getTopic(), claim.getFocus(), component, false);
	}
	
	public void assign(Topic topic, Focus focus) {
		new Assignment(this, topic, focus, component, true);
	}

	public void addClaim(Claim claim) {
		claims.add(claim);
	}

	public void deactivateClaims() {
		for(Claim claim: claims) {
			claim.deactivate();
		}
	}
	
	
	//getters and setters
	
	public List<Claim> getClaims() {
		return claims;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getPeriod() {
		return period;
	}

}
