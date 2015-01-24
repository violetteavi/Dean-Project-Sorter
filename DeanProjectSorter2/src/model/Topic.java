package model;

import java.util.LinkedList;
import java.util.List;

public class Topic {

	private String name;
	
	private List<Focus> focuses;
	private List<Claim> claims;
	private Assignment assignment;
	private TopicComponent component;
	
	public Topic(String topicName, TopicComponent component) {
		name = topicName;
		this.component = component;
		focuses = new LinkedList<Focus>();
		claims = new LinkedList<Claim>();
		component.addTopic(this);
	}

	public void addClaim(Claim newClaim) {
		claims.add(newClaim);
	}

	public void addFocus(Focus focus) {
		focuses.add(focus);
	}

	public int numActiveClaims() {
		int activeClaims = 0;
		for(Claim claim: claims) {
			if(claim.isActive()) {
				activeClaims++;
			}
		}
		return activeClaims;
	}
	
	//getters and setters
	
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
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
